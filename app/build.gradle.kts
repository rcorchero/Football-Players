import org.jetbrains.kotlin.config.KotlinCompilerVersion

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
            buildConfigField("okhttp3.logging.HttpLoggingInterceptor.Level", "LEVEL_LOGS", "okhttp3.logging.HttpLoggingInterceptor.Level.NONE")
        }
        getByName("debug") {
            isDebuggable = true
            buildConfigField("okhttp3.logging.HttpLoggingInterceptor.Level", "LEVEL_LOGS", "okhttp3.logging.HttpLoggingInterceptor.Level.BODY")
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

val appCompatVersion = "1.1.0"
val coroutinesVersion = "1.1.1"

val constraintLayoutVersion = "1.1.3"
val materialVersion = "1.0.0"

val picassoVersion = "2.71828"

val retrofitVersion = "2.3.0"
val okhttpVersion = "3.5.0"
val gsonVersion = "2.8.2"

val daggerVersion = "2.17"

val JUnitVersion = "4.12"
val extJUnitVersion = "1.1.0"
val espressoVersion = "3.2.0"

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Kotlin
    implementation(kotlin("stdlib-jdk7", KotlinCompilerVersion.VERSION))
    implementation("androidx.appcompat:appcompat:$appCompatVersion")
    implementation("androidx.core:core-ktx:$appCompatVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")

    // Design
    implementation("androidx.constraintlayout:constraintlayout:$constraintLayoutVersion")
    implementation("com.google.android.material:material:$materialVersion")

    // Picasso
    implementation("com.squareup.picasso:picasso:$picassoVersion")

    // Retrofit OkHttp
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    implementation("com.squareup.okhttp3:okhttp:$okhttpVersion")
    implementation("com.squareup.okhttp3:logging-interceptor:$okhttpVersion")

    // Gson
    implementation("com.google.code.gson:gson:$gsonVersion")

    // Dagger
    kapt("com.google.dagger:dagger-compiler:$daggerVersion")
    implementation("com.google.dagger:dagger:$daggerVersion") {
        exclude(group = "com.android.support")
        exclude(module = "appcompat-v7")
        exclude(module = "support-v4")
    }

    // Dagger Android
    kapt("com.google.dagger:dagger-android-processor:$daggerVersion")
    implementation("com.google.dagger:dagger-android:$daggerVersion")
    implementation("com.google.dagger:dagger-android-support:$daggerVersion") {
        exclude(group = "com.android.support")
        exclude(module = "appcompat-v7")
        exclude(module = "support-v4")
    }

    // Test
    testImplementation("junit:junit:$JUnitVersion")
    androidTestImplementation("androidx.test.ext:junit:$extJUnitVersion")
    androidTestImplementation("androidx.test.espresso:espresso-core:$espressoVersion")
}