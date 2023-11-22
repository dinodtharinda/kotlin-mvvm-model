plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id("androidx.navigation.safeargs")
}

android {
    namespace = "edu.hardwork.mvvmmodel"
    compileSdk = 34

    defaultConfig {
        applicationId = "edu.hardwork.mvvmmodel"
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

    dataBinding{
        enable = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //Retrofit and GSON
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.0")

    // ViewModel and LiveDate
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel:2.3.1")

    //kotlin Coroutines
    implementation( "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")

    //kodein Dependency Injection

//    implementation ("org.kodein.di:kodein-di-generic-jvm:7.3.1")

    //Android Room
    implementation( "androidx.room:room-runtime:2.6.0")
    implementation( "androidx.room:room-ktx:2.6.0")
    kapt ("androidx.room:room-compiler:2.6.0")
//    annotationProcessor ("androidx.room:room-compiler:2.4.0")

    //Android Navigation Architecture
    implementation ("androidx.navigation:navigation-fragment-ktx:2.7.5")
    implementation ("androidx.navigation:navigation-ui-ktx:2.7.5")

}