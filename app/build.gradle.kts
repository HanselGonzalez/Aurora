plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.sign.aurora"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.sign.aurora"
        minSdk = 24
        targetSdk = 34
        versionCode = 3
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {

        getByName("release"){
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = false

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            resValue("string","auroraname","Aurora")
            resValue("string","ADMOB_ID_MANIFEST","ca-app-pub-1256986380476629~5673668238")
            resValue("string","ADMOB_ID_ADS","ca-app-pub-1256986380476629/2283133850")

        }

        getByName("debug"){
            isDebuggable = true

            resValue("string","auroraname","[DEBUG] Aurora")
            resValue("string","ADMOB_ID_MANIFEST","ca-app-pub-3940256099942544~3347511713")
            resValue("string","ADMOB_ID_ADS","ca-app-pub-3940256099942544/1033173712")


        }

    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }


    buildFeatures {
        viewBinding = true
        buildConfig = true
    }


}

dependencies {


    val navVersion = "2.7.7"


    //Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")

    //Splash
    implementation("androidx.core:core-splashscreen:1.2.0-alpha01")

    //ADS
    implementation("com.google.android.gms:play-services-ads:23.1.0")

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


}