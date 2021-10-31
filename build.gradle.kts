import com.google.protobuf.gradle.proto
import com.google.protobuf.gradle.protobuf
import com.google.protobuf.gradle.protoc
import java.net.URI

plugins {
    id("com.google.protobuf") version "0.8.17"
    java
    application
    idea
}

val protobufVersion = "3.18.1"
val protocVersion = protobufVersion

group = "io.bparolini"
version = "1.0"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:$protocVersion"
    }
}

sourceSets {
    main {
        java {
            srcDirs("build/generated/source/proto/main/java")
        }
        proto {
            srcDir("src/main/proto")
            include("**/*.proto")
            exclude("google/**/*.proto")
        }
    }
    test {
        proto {
            srcDir("src/test/proto")
            include("**/*.proto")
            exclude("google/**/*.proto")
        }
    }
}

repositories {
    maven {
        url = URI("https://maven-central.storage-download.googleapis.com/maven2/")
    }
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("com.google.protobuf:protobuf-java:$protobufVersion")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks {
    test {
        useJUnitPlatform()
    }
}

idea {
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
}
