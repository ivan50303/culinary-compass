plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
   // kotlin("android.extensions")
    //id("com.google.devtools.ksp")
}

android {
    namespace = "edu.uncc.culinarycompass"
    compileSdk = 34

    defaultConfig {
        applicationId = "edu.uncc.culinarycompass"
        minSdk = 22
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.7.0")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation ("com.google.android.material:material:1.11.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    //carousel view
    //implementation ("io.coil-kt:coil:2.5.0")
    implementation ("com.google.android.material:material:1.10.0")
    implementation ("com.github.bumptech.glide:glide:4.16.0")



    //circle image view
    implementation ("de.hdodenhof:circleimageview:3.1.0")

    //scalable unit text size
    implementation ("com.intuit.ssp:ssp-android:1.0.6")

    //scalable unit size
    implementation ("com.intuit.sdp:sdp-android:1.0.6")

    //room database
    implementation ("androidx.room:room-runtime:2.2.5")
    kapt ("androidx.room:room-compiler:2.2.5")
    //ksp("androidx.room:room-compiler:2.5.0")
    implementation ("androidx.room:room-ktx:2.2.1")
    implementation ("com.makeramen:roundedimageview:2.3.0")
    implementation ("androidx.recyclerview:recyclerview:1.1.0")
    //crop image library

    //implementation ("com.theartofdev.edmodo:android-image-cropper:2.8.0")

    //easy permission

    implementation ("pub.devrel:easypermissions:3.0.0")

    //coroutines core
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.1")

    //Google flexbox
    implementation ("com.google.android.flexbox:flexbox:3.0.0")
}