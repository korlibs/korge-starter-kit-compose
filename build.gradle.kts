import korlibs.korge.gradle.*

plugins {
	alias(libs.plugins.korge)
	id("org.jetbrains.compose") version "1.4.0"
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
}

dependencies {
    add("commonMainApi", project(":deps"))
    //add("commonMainApi", project(":korge-dragonbones"))
}

compose {
	kotlinCompilerPluginArgs.add("suppressKotlinVersionCompatibilityCheck=1.8.21")
	kotlinCompilerPlugin.set(dependencies.compiler.forKotlin("1.8.20"))
}
