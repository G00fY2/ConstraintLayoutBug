plugins {
    id("com.android.application") version "4.1.2"
    kotlin("android") version "1.4.30"
}

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.g00fy2.constraintlayoutbug"
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }
    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures {
        viewBinding = true
    }
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.recyclerview:recyclerview:1.1.0")
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
}