plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt") // Apply kapt plugin directly
}

android {
    namespace = "com.example.musicquizapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.musicquizapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        dataBinding = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation("com.squareup.retrofit2:retrofit:2.9.0") // Retrofit core
    implementation("com.squareup.retrofit2:converter-gson:2.9.0") // Gson converter
    // Optional: If you plan to use Kotlin Coroutines with Retrofit
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.runtime.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation("androidx.room:room-runtime:2.6.1") // Add Room runtime
    implementation("androidx.room:room-ktx:2.6.1")     // Add Room KTX
    kapt("androidx.room:room-compiler:2.6.1")         // Add Room compiler
    implementation(libs.androidx.navigation.fragment)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
