# twentyone-kt

### Prerequisite

The assignment was written in Kotlin, using Java 21 sdk, to run and compile it with terminal you must have installed and
configured JDK, Kotlin and Gradle.
Opening the project in IntelliJ IDEA should work automagically, as it should automatically download the dependencies and
configure the project for you.

#### Using homebrew

```bash

# Install homebrew if you don't have it
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"

# Install Java 21, Kotlin and Gradle
brew install openjdk@21
brew install kotlin
brew install gradle

# Be aware that you might need to set your JAVA_HOME and/or symlink the JDK.
# Google or ChatGPT should be a better help than this README.
```

### How to build and run

```bash
# Build the project
./gradlew clean build
```

You can run the application with or without an input file.

```bash
# Run the project with an input file (see other example files in the /resources/input directory)
./gradlew run --args="both-blackjack"
```

If you don't provide an input file, a random deck will be generated.

```bash
# Run the project with a generated random deck
./gradlew run
```

### How to test

```bash
# Run tests
./gradlew clean build test
```

You can find the test report in `build/reports/tests/test/index.html`.

```bash
# Run tests with console output
./gradlew clean build test --info
```

# test
