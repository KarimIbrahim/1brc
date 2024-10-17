package com.karimibrahim.brc.naive

import java.io.File
import java.util.TreeMap
import kotlin.math.max
import kotlin.math.min

data class Record(
    var min: Float = Float.MAX_VALUE,
    var max: Float = Float.MIN_VALUE,
    var count: Int = 0,
    var sum: Float = 0f,
)

val floatFormat = "%.1f"

object NaiveBrc {

    fun calculateAverage(filePath: String) {
        val records: TreeMap<String, Record> = TreeMap()
        val bufferedReader = File(filePath).bufferedReader()
        bufferedReader.forEachLine {
            val parts = it.split(";")
            val name = parts[0]
            val temp = parts[1].toFloat()

            val record: Record
            if (name !in records) {
                record = Record()
                records[name] = record
            } else {
                record = records.getValue(name)
            }

            record.count += 1
            record.sum += temp
            record.min = min(record.min, temp)
            record.max = max(record.max, temp)
        }

        val stringBuilder = StringBuilder()
        records.keys.forEach {
            val record = records.getValue(it)
            stringBuilder.append(it)
            stringBuilder.append("=")
            stringBuilder.append(floatFormat.format(record.min))
            stringBuilder.append("/")
            stringBuilder.append(floatFormat.format(record.sum/record.count))
            stringBuilder.append("/")
            stringBuilder.append(floatFormat.format(record.max))
            stringBuilder.append(", ")
        }

        println("{${stringBuilder.removeSuffix(", ")}}")
    }
}
