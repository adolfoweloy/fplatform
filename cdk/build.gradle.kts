plugins {
    id("java")
}

group = "com.aafintech"
version = "1.0-SNAPSHOT"

val cdkVersion = "2.219.0"
val awsSdkVersion = "2.219.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("software.amazon.awscdk:aws-cdk-lib:${cdkVersion}")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

// Tasks to run the CDK apps
tasks.register<JavaExec>("runBootstrap") {
    mainClass.set("com.aafintech.BootstrapApp")
    classpath = sourceSets.main.get().runtimeClasspath
}

// Tests
tasks.test {
    useJUnitPlatform()
}