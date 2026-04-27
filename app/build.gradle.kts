plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.commonlauncher.nativeplugin"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.commonlauncher.nativeplugin"
        minSdk = 26
        targetSdk = 34
        versionCode = 2
        versionName = "1.1-FabricReady"

        ndk {
            abiFilters += listOf("arm64-v8a")
        }

        manifestPlaceholders["des"] = "MaliBridge — EngenhariaSonora (Universal 1.21.1)"
        manifestPlaceholders["renderer"] = "mali"
        manifestPlaceholders["boatEnv"] = ""
        manifestPlaceholders["pojavEnv"] = ""
        manifestPlaceholders["minMCVer"] = "1.17"
        manifestPlaceholders["maxMCVer"] = "1.21.99"
    }

    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
            version = "3.22.1"
        }
    }

    packaging {
        jniLibs {
            useLegacyPackaging = true
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
}
