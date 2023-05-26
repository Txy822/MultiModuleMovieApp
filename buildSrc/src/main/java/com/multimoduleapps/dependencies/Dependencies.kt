
package com.multimoduleapps.dependencies
object Versions {
    const val kotlin = Deps.Kotlin.kotlinVersion
    const val koin = "3.1.5"
}

object BuildCfg {
    const val compileSdk = 33
    const val minSdk = 23
    const val targetSdk = compileSdk
}
object Deps {
    object AndroidX {
        private const val androidx_annotation = "1.1.0"
        private const val androidx_appcompat = "1.2.0"
        private const val androidx_core = "1.3.2"
        private const val androidx_lifecycleVersion = "2.2.0"

        const val annotation = "androidx.annotation:annotation:$androidx_annotation"
        const val appcompat = "androidx.appcompat:appcompat:$androidx_appcompat"
        const val core_ktx = "androidx.core:core-ktx:$androidx_core"
        const val material_icon ="androidx.compose.material:material-icons-core:1.4.3"
        const val material_icon_extended ="androidx.compose.material:material-icons-extended:1.4.3"
        const val lifecycle_runtime ="androidx.lifecycle:lifecycle-runtime-ktx:$androidx_lifecycleVersion"

    }
    object Room {
        const val runtime = "androidx.room:room-runtime:2.5.1"
        const val compiler = "androidx.room:room-compiler:2.5.1"
        const val ktx ="androidx.room:room-ktx:2.5.1"
    }

    object Kotlin {
        const val kotlinVersion = "1.7.10"
        const val stdlib_jdk = "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"
        const val stdlib_common = "org.jetbrains.kotlin:kotlin-stdlib-common:$kotlinVersion"
        const val test_common = "org.jetbrains.kotlin:kotlin-test-common:$kotlinVersion"
        const val test_annotations = "org.jetbrains.kotlin:kotlin-test-annotations-common:$kotlinVersion"
        const val test_jdk = "org.jetbrains.kotlin:kotlin-test:$kotlinVersion"
        const val test_junit = "org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion"
        const val test_reflect = "org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion"
    }

    object KotlinX {
        private const val version = "1.5.1"
        const val kotlinx_coroutines_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val kotlinx_coroutines_android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
    }

    object Google {
        private const val version = "0.20.0"

        const val googleAccompanist_sys = "com.google.accompanist:accompanist-systemuicontroller:${version}"

        object PlayServices {
        }
    }

    object Firebase {
        const val crashlytics = "com.google.firebase:firebase-crashlytics-buildtools:2.8.1"
    }

    object OkHttp3 {
        private const val okhttp3 = "4.9.3"
        const val client = "com.squareup.okhttp3:okhttp:$okhttp3"
        const val logging = "com.squareup.okhttp3:logging-interceptor:$okhttp3"
        const val mockWebServer = "com.squareup.okhttp3:mockwebserver:$okhttp3"
    }

    object OkHttp2 {
        private const val okhttp2 = "2.7.5"
        const val client = "com.squareup.okhttp:okhttp:$okhttp2"
    }

    object Retrofit {
        private const val version = "2.9.0"
        const val client = "com.squareup.retrofit2:retrofit:$version"
        const val converterGson = "com.squareup.retrofit2:converter-gson:$version"
    }
    object Hilt {
        private const val version ="2.44"
        const val hilt = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-compiler:$version"


    }

    object Test {
        const val junit = "junit:junit:4.13.2"
        const val junit_ext = "androidx.test.ext:junit:1.1.5"
        const val espresso ="androidx.test.espresso:espresso-core:3.5.1"
        const val compose_test = "androidx.compose.ui:ui-test-junit4:1.4.3"
        const val ui_test_manifest ="androidx.compose.ui:ui-test-manifest:1.4.3"
        const val mockito_kotlin = "org.mockito.kotlin:mockito-kotlin:3.2.0"
        const val mockito = "org.mockito:mockito-core:3.10.0"

    }

    object Compose {
        const val compileVersion = "1.7.10"
        private const val compileVersionExtension = "1.3.0"
        private const val composeVersion = "1.4.3"
        private const val nav_version = "2.5.0"
        private const val  hilt_nav_version = "1.0.0"

        const val runtime = "androidx.compose.runtime:runtime:$composeVersion"
        const val ui = "androidx.compose.ui:ui:$composeVersion"

        const val foundation = "androidx.compose.foundation:foundation:$composeVersion"
        const val foundationLayout = "androidx.compose.foundation:foundation-layout:$composeVersion"
        const val material = "androidx.compose.material:material:$composeVersion"
        const val runtimeLivedata = "androidx.compose.runtime:runtime-livedata:$composeVersion"
        const val uiTooling = "androidx.compose.ui:ui-tooling:$composeVersion"
        const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:$composeVersion"
        const val composeThemeAdapter = "com.google.android.material:compose-theme-adapter:1.1.17"
        const val composeActivity = "androidx.activity:activity-compose:$compileVersionExtension"
        const val composeNavigation = "androidx.navigation:navigation-compose:$nav_version"
        const val hiltNavigation  = "androidx.hilt:hilt-navigation-compose:$hilt_nav_version"
    }
    object Coil {
        private const val coilVersion ="2.4.0"
        const val coil = "io.coil-kt:coil-compose:$coilVersion"
    }
}
