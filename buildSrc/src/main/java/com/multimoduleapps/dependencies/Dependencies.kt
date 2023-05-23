
package com.multimoduleapps.dependencies
object Versions {
    const val kotlin = Deps.Kotlin.kotlinVersion
    const val detekt = Deps.DevTools.Detekt.version
    const val jacoco = "0.8.7"
    const val koin = "3.1.5"
}

object BuildCfg {
    const val compileSdk = 33
    const val minSdk = 23
    const val targetSdk = compileSdk
    const val buildTools = "30.0.3"
}
object Deps {
    object AndroidX {
        private const val androidx_annotation = "1.1.0"
        private const val androidx_recyclerview = "1.0.0"
        private const val androidx_appcompat = "1.2.0"
        private const val androidx_cardview = "1.0.0"
        private const val androidx_core = "1.3.2"
        private const val androidx_preference = "1.1.0"
        private const val androidx_legacy = "1.0.0"
        private const val androidx_constraintlayout = "2.0.4"
        private const val androidx_multidex = "2.0.1"
        private const val androidx_navigation = "2.3.4"
        private const val androidx_lifecycleVersion = "2.2.0"
        private const val androidx_swiperefreshlayout = "1.0.0"
        private const val androidx_test_runner = "1.4.0"
        private const val androidx_test_rules = "1.4.0"
        private const val androidx_test_ext = "1.1.3"
        private const val androidx_test_expresso = "3.4.0"
        private const val androidx_security_crypto = "1.0.0-rc03"
        private const val androidx_viewpager2 = "1.0.0"
        private const val androidx_lifecycle = "2.5.1"
        private const val safeargs = "2.3.4"
        private const val androidx_fragment_ktx = "1.5.5"
        const val annotation = "androidx.annotation:annotation:$androidx_annotation"
        const val recyclerview = "androidx.recyclerview:recyclerview:$androidx_recyclerview"
        const val appcompat = "androidx.appcompat:appcompat:$androidx_appcompat"
        const val cardview = "androidx.cardview:cardview:$androidx_cardview"
        const val core_ktx = "androidx.core:core-ktx:$androidx_core"
        const val preference = "androidx.preference:preference:$androidx_preference"
        const val preference_ktx = "androidx.preference:preference-ktx:$androidx_preference"
        const val legacy_preference_v14 = "androidx.legacy:legacy-preference-v14:$androidx_legacy"
        const val legacy_support_v4 = "androidx.legacy:legacy-support-v4:$androidx_legacy"
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:$androidx_constraintlayout"
        const val multidex = "androidx.multidex:multidex:$androidx_multidex"
        const val navigation_fragment_ktx = "androidx.navigation:navigation-fragment-ktx:$androidx_navigation"
        const val navigation_ui_ktx = "androidx.navigation:navigation-ui-ktx:$androidx_navigation"
        const val lifecycle = "androidx.lifecycle:lifecycle-process:$androidx_lifecycleVersion"
        const val lifecycle_extensions = "androidx.lifecycle:lifecycle-extensions:$androidx_lifecycleVersion"
        const val lifecycle_runtime ="androidx.lifecycle:lifecycle-runtime-ktx:$androidx_lifecycleVersion"
        const val lifecycle_viewmodel = "androidx.lifecycle:lifecycle-viewmodel:$androidx_lifecycle"
        const val lifecycle_viewmodel_ktx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$androidx_lifecycle"
        const val security_crypto = "androidx.security:security-crypto:$androidx_security_crypto"
        const val swiperefreshlayout = "androidx.swiperefreshlayout:swiperefreshlayout:$androidx_swiperefreshlayout"
        const val viewpager2 = "androidx.viewpager2:viewpager2:$androidx_viewpager2"
        const val test_runner = "androidx.test:runner:$androidx_test_runner"
        const val test_ext = "androidx.test.ext:junit:$androidx_test_ext"
        const val test_rules = "androidx.test:rules:$androidx_test_rules"
        const val test_espresso = "androidx.test.espresso:espresso-core:$androidx_test_expresso"
        const val fragment_ktx = "androidx.fragment:fragment-ktx:$androidx_fragment_ktx"

        const val safeargsplugin = "androidx.navigation:navigation-safe-args-gradle-plugin:$safeargs"
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
        private const val materialVersion = "1.4.0"
        const val android_material = "com.google.android.material:material:$materialVersion"
        const val android_utils_maps = "com.google.maps.android:android-maps-utils:0.4.3"

        const val tinkVersion = "1.4.0"
        const val tink = "com.google.crypto.tink:tink-android" // no version included as it requires override in gradle.

        object PlayServices {
            const val maps = "com.google.android.gms:play-services-maps:18.0.2"
            const val location = "com.google.android.gms:play-services-location:19.0.0"
            const val analytics = "com.google.android.gms:play-services-analytics:18.0.1"
            const val tagmanager = "com.google.android.gms:play-services-tagmanager:18.0.1"
            const val gcm = "com.google.android.gms:play-services-gcm:17.0.0"
            const val wallet = "com.google.android.gms:play-services-wallet:19.1.0"
        }
    }

    object Firebase {
        const val config = "com.google.firebase:firebase-config:21.1.1"
        const val config_ktx = "com.google.firebase:firebase-config-ktx:21.1.1"
        const val analytics = "com.google.firebase:firebase-analytics:21.1.0"
        const val analytics_ktx = "com.google.firebase:firebase-analytics-ktx:21.1.0"
        const val messaging = "com.google.firebase:firebase-messaging:23.0.7"
        const val performance_monitoring_sdk = "com.google.firebase:firebase-perf-ktx:20.1.0"
        const val performance_monitoring_plugin = "com.google.firebase:perf-plugin:1.4.1"
        const val iid = "com.google.firebase:firebase-iid:21.1.0"
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
        private const val version = "2.5.0"
        const val client = "com.squareup.retrofit2:retrofit:$version"
        const val converterGson = "com.squareup.retrofit2:converter-gson:$version"
        const val rxjavaAdapter = "com.squareup.retrofit2:adapter-rxjava2:$version"
    }

    object Dagger {
        private const val version = "2.20"
        const val runtime = "com.google.dagger:dagger:$version"
        const val compiler = "com.google.dagger:dagger-compiler:$version"
        const val android_runtime = "com.google.dagger:dagger-android:$version"
        const val android_runtime_support = "com.google.dagger:dagger-android-support:$version"
        const val android_compiler = "com.google.dagger:dagger-android-processor:$version"
    }

    object Hilt {
        private const val version ="2.44"


        const val hilt = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-compiler:$version"


    }

    object Stetho {
        private const val version = "1.5.0"
        const val runtime = "com.facebook.stetho:stetho:$version"
        const val okhttp = "com.facebook.stetho:stetho-okhttp3:$version"
    }

    object Appcenter {
        private const val appCenter = "1.0.0"
        const val analytics = "com.microsoft.appcenter:appcenter-analytics:$appCenter"
        const val crashes = "com.microsoft.appcenter:appcenter-crashes:$appCenter"
    }

    const val salesforce_marketingcloud = "com.salesforce.marketingcloud:marketingcloudsdk:8.0.6"

    object Utils {
        const val spoon = "com.squareup.spoon:spoon-client:1.7.0"
        const val assertj = "com.squareup.assertj:assertj-android:1.1.1"

        const val dotsindicator = "com.tbuonomo:dotsindicator:4.2"
        const val javaxAnnotation = "javax.annotation:javax.annotation-api:1.2"
        const val picasso = "com.squareup.picasso:picasso:2.5.2"
        const val timber = "com.jakewharton.timber:timber:4.7.1"
        const val rxBinding = "com.jakewharton.rxbinding2:rxbinding:2.0.0"
        const val rxandroid = "io.reactivex.rxjava2:rxandroid:2.1.1"
        const val rxjava = "io.reactivex.rxjava2:rxjava:2.2.0"
        const val threetenabp = "com.jakewharton.threetenabp:threetenabp:1.3.0"
        const val libphonenumber = "com.googlecode.libphonenumber:libphonenumber:8.8.2"
        const val stickyheadersrecyclerview ="com.timehop.stickyheadersrecyclerview:library:0.4.3@aar"
        const val qrcode = "com.google.zxing:core:3.3.3"
        const val apptentive = "com.apptentive:apptentive-android:5.8.4"
        const val install_referrer = "com.android.installreferrer:installreferrer:1.0"
        const val materialSpinner = "com.github.ganfra:material-spinner:1.1.1"
        const val securePreferences = "com.scottyab:secure-preferences-lib:0.1.7"
        const val progressbar = "com.github.firdausmaulan:AVLoadingIndicatorView:2.3.0" // To be removed FRL-5903
        const val crashlytics = "com.google.firebase:firebase-crashlytics:18.0.0"
        const val gson = "com.google.code.gson:gson:2.8.5"
        const val exif_interface = "androidx.exifinterface:exifinterface:1.3.3"
        const val stringSanitiser = "com.futureplatforms:string-sanitiser:0.1.5"
        const val stringSanitiserKapt = "com.futureplatforms:string-sanitiser-kapt:0.1.5"
    }

    object Test {
        const val junit = "junit:junit:4.13.2"
        const val junit_ext = "androidx.test.ext:junit:1.1.5"
        const val espresso ="androidx.test.espresso:espresso-core:3.5.1"
        const val compose_test = "androidx.compose.ui:ui-test-junit4:1.4.3"
        const val ui_test_manifest ="androidx.compose.ui:ui-test-manifest:1.4.3"
        const val mockito_kotlin = "org.mockito.kotlin:mockito-kotlin:3.2.0"
        const val mockito = "org.mockito:mockito-core:3.10.0"
        const val mockito_inline = "org.mockito:mockito-inline:3.10.0"
        const val assertj = "org.assertj:assertj-core:3.2.0"
        const val robolectric = "org.robolectric:robolectric:3.4.2"
        const val robolectricMultidex = "org.robolectric:shadows-multidex:3.4-rc2"
        const val json = "org.json:json:20140107"
        const val dexmaker = "com.google.dexmaker:dexmaker:1.2"
        const val dexmaker_mockito = "com.google.dexmaker:dexmaker-mockito:1.2"
        const val threetenbp = "org.threeten:threetenbp:1.5.0"

        object Kotest {
            val assertions = "io.kotest:kotest-assertions-core:5.2.1"
        }
    }

    /**
     * Specifically for libraries that do not tangibly impact the release app.
     */
    object DevTools {
        object Detekt {
            const val version = "1.19.0"
            const val detektplugin = "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:$version"
            const val detektformatting = "io.gitlab.arturbosch.detekt:detekt-formatting:$version"
        }
        const val jacocoVersion = "0.8.8"
    }

    const val dynatraceplugin = "com.dynatrace.tools.android:gradle-plugin:8.247.1.1003"
    const val fp_recyclerview = "com.futureplatforms:view-recyclerview:0.1.3"
    const val lottie = "com.airbnb.android:lottie:3.7.0"
    const val lottieCompose = "com.airbnb.android:lottie-compose:6.0.0"
    const val flexBox = "com.google.android.flexbox:flexbox:3.0.0"

    object Compose {
        const val compileVersion = "1.7.10"
        private const val compileVersionExtension = "1.3.0"
        private const val composeVersion = "1.4.3"
        private const val nav_version = "2.5.0"
        private const val  hilt_nav_version = "1.0.0"
        private const val googleAccompanistVersion ="0.31.2-alpha"


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
        const val googleAccompanist = "com.google.accompanist:accompanist-navigation-animation:$googleAccompanistVersion"
    }

    object Koin {
        const val android = "io.insert-koin:koin-android:${Versions.koin}"
    }

    object Qubit{
        const val android = "com.qubit:qubit-sdk-android:2.0.2"
    }
}
