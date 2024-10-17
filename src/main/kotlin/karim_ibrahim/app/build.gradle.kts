plugins {
    id("buildlogic.kotlin-application-conventions")
}

dependencies {
    implementation("org.apache.commons:commons-text")
    implementation(project(":naive"))
}

application {
    mainClass = "com.karimibrahim.brc.MainKt"
}

tasks.jar {
    dependsOn(configurations.runtimeClasspath)
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    manifest {
        attributes["Implementation-Title"] = "1BRC"
        attributes["Implementation-Version"] = version
        attributes["Main-Class"] = "com.karimibrahim.brc.MainKt"
    }
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}
