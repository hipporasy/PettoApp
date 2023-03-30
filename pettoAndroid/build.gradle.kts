plugins {
    id("com.android.application")
    kotlin("android")
    id("dagger.hilt.android.plugin")
    id("com.google.devtools.ksp")
    id("org.jetbrains.kotlin.kapt")
}

android {
    namespace = "codes.hipporasy.pettoapp.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "codes.hipporasy.pettoapp.android"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

android.applicationVariants.all {
    addJavaSourceFoldersToModel(File(buildDir, "generated/ksp/${this.name}/kotlin"))
}

dependencies {
    implementation(project(":pettoCore"))
    implementation("androidx.compose.ui:ui:1.3.1")
    implementation("androidx.compose.ui:ui-tooling:1.3.1")
    implementation("androidx.compose.ui:ui-tooling-preview:1.3.1")
    implementation("androidx.compose.foundation:foundation:1.3.1")
    implementation("androidx.compose.material:material:1.3.1")
    implementation("androidx.activity:activity-compose:1.6.1")
    implementation("com.jakewharton.timber:timber:5.0.1")
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.29.0-alpha")
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.0")


    // Dagger - Hilt
    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")

    // Compose dependencies
    implementation("androidx.navigation:navigation-compose:2.5.3")
    implementation("io.github.raamcosta.compose-destinations:core:1.8.33-beta")
    implementation("io.github.raamcosta.compose-destinations:animations-core:1.8.33-beta")
    ksp("io.github.raamcosta.compose-destinations:ksp:1.8.33-beta")
}