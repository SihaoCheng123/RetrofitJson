plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.retrofitexample"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.retrofitexample"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.retrofit)
    implementation(libs.converter.scalars)
    implementation (libs.retrofit.v210)
    implementation (libs.converter.gson)
    implementation (libs.converter.gson.vlatestversion)
    implementation (libs.gson)
    implementation(libs.retrofit.v2110)
    implementation (libs.converter.gson.v290)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation(libs.converter.gson.v2110)
}