plugins {
    id("com.android.application")
    id(KotlinPlugins.kotlinAndroid)
    id(Plugins.hilt)
    kotlin(KotlinPlugins.android)
    kotlin(KotlinPlugins.kapt)
    kotlin(KotlinPlugins.serialization) version Kotlin.version
}

android {
    compileSdk = 33
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0"
    }
    defaultConfig {
        applicationId = "ru.ukenov.food2forkkmm.android"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(Google.material)
    implementation(AndroidX.appCompat)
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")

    implementation(Compose.runtime)
    implementation(Compose.runtimeLiveData)
    implementation(Compose.ui)
    implementation(Compose.material)
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.1")
    implementation(Compose.previewTooling)
    debugImplementation(Compose.uiTooling)
    implementation(Compose.foundation)
    implementation(Compose.compiler)
    implementation(Compose.constraintLayout)
    implementation(Compose.activity)
    implementation(Compose.navigation)

    implementation(Hilt.hiltAndroid)
    implementation(Hilt.hiltNavigation)
    implementation(Hilt.hiltCompiler)

    implementation(Kotlinx.datetime)

    debugImplementation(SquareUp.leakCanary)
}