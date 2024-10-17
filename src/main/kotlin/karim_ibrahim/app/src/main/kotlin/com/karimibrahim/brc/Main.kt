package com.karimibrahim.brc

import com.karimibrahim.brc.naive.NaiveBrc

fun main(args: Array<String>) {
    var filePath = "./measurements.txt"
    if (args.isNotEmpty()) {
        filePath = args.first()
    }
    NaiveBrc.calculateAverage(filePath)
}
