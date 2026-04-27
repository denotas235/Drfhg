plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.commonlauncher.nativeplugin"
    compileSdk = 34

    signingConfigs {
        create("releaseBuild") {
            storeFile = file("common_plugin.jks")
            storePassword = "common_plugin"
            keyAlias = "common_plugin"
            keyPassword = "common_plugin"
        }
    }

    defaultConfig {
        applicationId = "com.commonlauncher.nativeplugin"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        ndk {
            abiFilters += listOf("arm64-v8a")
        }
    }

    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
            version = "3.22.1"
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
        configureEach {
            resValue("string","app_name","MaliBridge")
            applicationIdSuffix = ".mali"

            manifestPlaceholders["des"] = "MaliBridge — Hardware Middleware para Mali-G52"
            manifestPlaceholders["environment"] = mutableMapOf<String,String>().apply {

            }.run {
                buildList {
                    this@run.forEach { (key, value) ->
                        add("-D$key=$value")
                    }
                }.joinToString(" ")
            }
            manifestPlaceholders["minMCVer"] = "1.17"
            manifestPlaceholders["maxMCVer"] = "1.21.99"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions { jvmTarget = "1.8" }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.aar"))))
    implementation(libs.androidx.core.ktx)
}
