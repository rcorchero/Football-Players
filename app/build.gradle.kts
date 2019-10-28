plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(29)
    buildToolsVersion = "29.0.2"
    flavorDimensions("default")

    defaultConfig {
        applicationId = "com.rcorchero.footballplayers"
        minSdkVersion(21)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            isDebuggable = true
        }
    }

    productFlavors {
        val string = "String"
        val host = "HOST"

        create("dev") {
            applicationIdSuffix = ".dev"
            versionNameSuffix = "-dev"
            buildConfigField(string, host, "\"https://www.thesportsdb.com/api/v1/json/\"")
        }

        create("pro") {
            buildConfigField(string, host, "\"https://www.thesportsdb.com/api/v1/json/\"")
        }
    }
}

val kotlinVersion = "1.3.50"
val appCompatVersion = "1.1.0"

val constraintLayoutVersion = "1.1.3"
val materialVersion = "1.0.0"

val JUnitVersion = "4.12"
val extJUnitVersion = "1.1.0"
val espressoVersion = "3.2.0"

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion")
    implementation("androidx.appcompat:appcompat:$appCompatVersion")
    implementation("androidx.core:core-ktx:$appCompatVersion")

    // Design
    implementation("androidx.constraintlayout:constraintlayout:$constraintLayoutVersion")
    implementation("com.google.android.material:material:$materialVersion")

    // Test
    testImplementation("junit:junit:$JUnitVersion")
    androidTestImplementation("androidx.test.ext:junit:$extJUnitVersion")
    androidTestImplementation("androidx.test.espresso:espresso-core:$espressoVersion")
}