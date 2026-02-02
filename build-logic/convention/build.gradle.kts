plugins {
    `kotlin-dsl`
}
group = "com.example.buildlogic"
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17)) // AGP 8+ требует JDK 17
    }
}

gradlePlugin {
    plugins {
        // Регистрация плагинjов
        register("androidLibrary") {
            id = "com.example.android.library"
            implementationClass = "com.example.convention.AndroidLibraryConventionPlugin"
        }
        register("androidComposeLibrary") {
            id = "com.example.android.compose.library"
            implementationClass = "com.example.convention.AndroidComposeLibraryConventionPlugin"
        }
    }
}

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
}
