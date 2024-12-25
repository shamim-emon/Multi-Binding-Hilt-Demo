
# Multi-Binding Hilt Demo

This repository demonstrates the use of **Hilt Multibinding** for **Dependency Injection** in Android applications. It provides a working example of how to use Hilt's multibinding feature to manage multiple dependencies of the same type in a scalable and maintainable way.

The code in this repository is explained in the [Medium blog post](https://medium.com/@emon.dev.bd/understanding-hilt-multibinding-a-powerful-tool-for-dependency-injection-in-android-335327f592cf), which covers the core concepts and implementation details of Hilt Multibinding.

## What is Hilt Multibinding?

**Hilt** is a modern, fully integrated dependency injection (DI) library for Android, built on top of Dagger. Multibinding is a feature in Hilt that allows you to bind multiple instances of the same type and inject them wherever needed.

In this example, we demonstrate how to use Hilt's multibinding capabilities to bind multiple implementations of an interface and inject them into the application.

## Features

- Demonstrates how to set up Hilt in an Android project.
- Shows how to use Hilt's `@IntoSet` and `@IntoMap` annotations to bind multiple instances of the same interface.
- Provides a clean, maintainable approach to dependency management with Hilt Multibinding.

## Setup Instructions

### Prerequisites

- Android Studio 4.0 or higher.
- Gradle 5.6 or higher.
- JDK 8 or higher.
- Kotlin 1.4 or higher.

### 1. Clone the repository

```bash
git clone https://github.com/shamim-emon/Multi-Binding-Hilt-Demo.git
```

### 2. Open the project in Android Studio

Open the project folder in Android Studio to start working with the demo.

### 3. Add Hilt dependencies

In your `build.gradle` files, add the necessary Hilt dependencies:

#### Project-level `build.gradle`:

```gradle
classpath "com.google.dagger:hilt-android-gradle-plugin:2.44"
```

#### App-level `build.gradle`:

```gradle
plugins {
    id 'com.android.application'
    id 'kotlin-android'
    id 'dagger.hilt.android.plugin'
}

dependencies {
    implementation "com.google.dagger:hilt-android:2.44"
    kapt "com.google.dagger:hilt-android-compiler:2.44"
}
```

### 4. Enable Hilt in your application

In your `Application` class, add the `@HiltAndroidApp` annotation:

```kotlin
@HiltAndroidApp
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
```

### 5. Implement Multibinding

- Use `@IntoSet` and `@IntoMap` annotations to bind multiple implementations of the same interface.
- Hilt automatically provides these implementations wherever they are injected.

### Example

```kotlin
interface Service {
    fun execute()
}

class ServiceA @Inject constructor() : Service {
    override fun execute() {
        println("Service A executed")
    }
}

class ServiceB @Inject constructor() : Service {
    override fun execute() {
        println("Service B executed")
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceModule {

    @Binds
    @IntoSet
    abstract fun bindServiceA(serviceA: ServiceA): Service

    @Binds
    @IntoSet
    abstract fun bindServiceB(serviceB: ServiceB): Service
}
```

### 6. Run the Demo

Once the dependencies are set up and Hilt is configured, you can run the app and observe the dependency injection in action.

## Learn More

For a detailed explanation of Hilt Multibinding and how it works, please refer to the following [Medium Blog Post](https://medium.com/@emon.dev.bd/understanding-hilt-multibinding-a-powerful-tool-for-dependency-injection-in-android-335327f592cf).

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
