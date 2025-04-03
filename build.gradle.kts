plugins {
    kotlin("jvm") version "2.1.10"
    application
}

group = "com.github.moln-r"
version = "1.0"

application {
    mainClass.set("com.github.molnr.GameKt")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}
