plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("kotlin-parcelize")
}

object Versions {
    const val ktor = "2.2.1"
    const val koin = "3.1.5"
    const val coroutines = "1.6.4"
    const val serialization = "1.4.1"
}


kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "pettoCore"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.serialization}")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.serialization}")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
                implementation("io.ktor:ktor-client-serialization:${Versions.ktor}")
                implementation("io.ktor:ktor-serialization-kotlinx-json:${Versions.ktor}")
                implementation("io.ktor:ktor-client-content-negotiation:${Versions.ktor}")
                implementation("io.ktor:ktor-client-logging:${Versions.ktor}")
                implementation("io.insert-koin:koin-core:${Versions.koin}")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
                implementation("io.ktor:ktor-client-okhttp:${Versions.ktor}")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.serialization}")
                implementation("io.insert-koin:koin-android:${Versions.koin}")
            }
        }
        val androidUnitTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependencies {
                implementation("io.ktor:ktor-client-darwin:${Versions.ktor}")
            }
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "codes.hipporasy.pettoapp"
    compileSdk = 33
    defaultConfig {
        minSdk = 26
        targetSdk = 33
    }
}