plugins {
    id("com.android.application")
    kotlin(KotlinPlugins.android)
    kotlin(KotlinPlugins.kapt)
    kotlin(KotlinPlugins.serialization) version Kotlin.version
}

android {
    compileSdk = 33
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
    implementation(Compose.uiTooling)
    implementation(Compose.foundation)
    implementation(Compose.compiler)
    implementation(Compose.constraintLayout)
    implementation(Compose.activity)
    implementation(Compose.navigation)

    implementation(Kotlinx.datetime)

    debugImplementation(SquareUp.leakCanary)
}