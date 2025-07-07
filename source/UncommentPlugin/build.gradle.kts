plugins {
    kotlin("jvm") version "1.9.22"
    id("org.jetbrains.intellij") version "1.17.3"
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

intellij {
    version.set("2024.1") // IntelliJ platform verzija
    type.set("IC")        // IC = Community Edition (kompatibilno i sa Rider-om)
}

tasks {
    patchPluginXml {
        sinceBuild.set("241")
        untilBuild.set("999.*")
    }

    runIde {
        // Opciono: možeš dodati custom IDE putanju
    }
}

kotlin {
    jvmToolchain(17)
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "17"
}
