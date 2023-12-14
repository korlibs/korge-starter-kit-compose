import korlibs.korge.gradle.*

plugins {
    alias(libs.plugins.korge)
    id("org.jetbrains.compose") version "1.5.11"
}

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
        google()
        gradlePluginPortal()
    }
}

korge {
    id = "korlibs.korge.starterkit.compose"
    name = "Korge Compose"
    title = name
    icon = file("icon.png")

// To enable all targets at once

    //targetAll()

// To enable targets based on properties/environment variables
    //targetDefault()

// To selectively enable targets

    targetJvm()
    targetJs()
    targetDesktop()
    targetIos()
    targetAndroid()

    serializationJson()

    androidCompileSdk = 29
    androidTargetSdk = 29
}

dependencies {
    add("commonMainApi", project(":deps"))
    //add("commonMainApi", project(":korge-dragonbones"))
}

compose {
    kotlinCompilerPluginArgs.add("suppressKotlinVersionCompatibilityCheck=1.9.20")
    kotlinCompilerPlugin.set(dependencies.compiler.forKotlin("1.9.20"))
}
