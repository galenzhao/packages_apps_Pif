plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.goolag.pif"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.goolag.pif"
        minSdk = 31
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        val appName = "Pif"
        manifestPlaceholders["appName"] = appName
//        applicationIdSuffix = ".demo"
        versionName = "1.0.0"
        versionNameSuffix = ".3"
        versionCode = (versionName + versionNameSuffix).replace(".", "").toInt()
        val apkName = "${appName}_$versionName$versionNameSuffix($versionCode).apk"

        // change app name block below
        buildOutputs.all {
            val variantOutputImpl = this as com.android.build.gradle.internal.api.BaseVariantOutputImpl
            variantOutputImpl.outputFileName =  apkName
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}