
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    // หากคุณใช้ Google Services (เช่น Firebase) ต้องมีปลั๊กอินนี้ด้วย
    // id("com.google.gms.google-services") // ถ้าไม่ได้ใช้ Firebase ก็ไม่ต้องมีบรรทัดนี้
}

android {
    // กำหนด namespace ของแอปพลิเคชันของคุณ
    // ควรตรงกับ applicationId หรือ package หลักของโปรเจกต์
    namespace = "com.example.realestateapp"

    // กำหนดเวอร์ชันของ SDK ที่ใช้ในการคอมไพล์
    compileSdk = 34

    defaultConfig {
        // กำหนด Application ID ของแอปพลิเคชัน
        applicationId = "com.example.realestateapp"

        // กำหนดเวอร์ชันขั้นต่ำของ Android ที่แอปจะรองรับ
        minSdk = 24 // Android 7.0 Nougat

        // กำหนดเวอร์ชันของ Android ที่แอปถูกทดสอบด้วย
        targetSdk = 34

        // กำหนดเวอร์ชันโค้ด (สำหรับ Play Store) และเวอร์ชันชื่อ (แสดงให้ผู้ใช้เห็น)
        versionCode = 1
        versionName = "1.0"

        // กำหนด Test Instrumentation Runner
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            // ตั้งค่าการลดขนาดโค้ด (minification) สำหรับ Build Type "release"
            isMinifyEnabled = false // ตั้งค่าเป็น true หากต้องการลดขนาดโค้ดจริง
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    // กำหนด Compatibility ของ Java Source และ Target
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    // *** กำหนด Kotlin Options สำหรับ JVM Target (ที่เคยเป็นปัญหา Unresolved reference) ***
    kotlinOptions {
        jvmTarget = "1.8" // กำหนดเวอร์ชัน JVM ที่ Kotlin จะคอมไพล์ไปถึง
    }

    // *** เปิดใช้งาน View Binding สำหรับการเข้าถึง View ใน Layout อย่างปลอดภัย ***
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // *** ใช้ libs.versions.toml สำหรับ dependencies ที่มีอยู่แล้ว เพื่อความสอดคล้อง ***
    implementation(libs.appcompat) // แทน androidx.appcompat:appcompat:1.6.1
    implementation(libs.material) // แทน com.google.android.material:material:1.12.0
    implementation(libs.constraintlayout) // แทน androidx.constraintlayout:constraintlayout:2.1.4
    implementation(libs.activity) // อันนี้คุณมีอยู่แล้ว

    // Core KTX - ส่วนขยาย Kotlin สำหรับ Android (ถ้า libs.core.ktx ไม่มี)
    // ถ้า libs.core.ktx มีอยู่แล้วใน libs.versions.toml ให้ใช้ตัวนั้นแทน
    implementation("androidx.core:core-ktx:1.13.1")

    // Test Dependencies
    testImplementation(libs.junit) // แทน junit:junit:4.13.2
    androidTestImplementation(libs.ext.junit) // แทน androidx.test.ext:junit:1.1.5
    androidTestImplementation(libs.espresso.core) // แทน androidx.test.espresso:espresso-core:3.5.1

    // *** หากคุณใช้ Firebase หรือ Google Services อื่นๆ ให้เพิ่ม dependencies ที่นี่ ***
    // ตัวอย่าง:
    // Firebase BOM (Bill of Materials) - ช่วยจัดการเวอร์ชันของ Firebase libraries
    // implementation(platform("com.google.firebase:firebase-bom:32.9.0"))
    // Firebase Analytics
    // implementation("com.google.firebase:firebase-analytics")
}