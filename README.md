# Kotlin/JVM 1.5 Inline Logging
[![](https://jitpack.io/v/CXwudi/kotlin-jvm-1_5-inline-logging.svg)](https://jitpack.io/#CXwudi/kotlin-jvm-1_5-inline-logging)

Powered by SLF4J, fully inlined, and say goodbye to lambda object creation 😲

## Prerequisites

- Java 8+
- Kotlin 1.5.0+

## Features

- Fully inlined SLF4J logger
- lazily create log message without creating lambda object (because everything is inlined 😋)
- only showing lazy logging methods on your IDE (e.g. showing `logger.info {}` on your auto-complete hint instead of `logger.info()`)

## How to import

Check [JitPack](https://jitpack.io/#CXwudi/kotlin-jvm-1_5-inline-logging) to see how to import

## How to use

Example:
```kotlin
private val logger = KInlineLogging.logger() // an instance of KInlineLogger, which is a value class of SLF4J Logger

class MainApp {
  fun start() {
    logger.info { "an info msg" }
    val exception = SomeException()
    logger.debug(exception) { "a debug msg with exception $exception" }
  }
}
```
Under the hook, this should be compiled as:
```kotlin
private val logger: Logger = LoggerFactory.getLogger(
  KInlineLoggerNameResolver.fixName(MethodHandles.lookup().lookupClass())
) // A SLF4J Logger, not the KInlineLogger 😯

class MainApp {
  fun start() {
    if (logger.isInfoEnabled()){
      logger.info("an info msg") // no lambda object created 😊
    }
    val exception = SomeException()
    if (logger.isDebugEnabled()){
      // notice that this string creation will not happen if the debug level is not enabled
      logger.debug("a debug msg with exception $exception", exception) 
    } 
  }
}
```

## Q: Can you support multi-platform?

A: Sorry, I am not supporting it, but you can just grab the only [two source files](./lib/src/main/kotlin/mikufan/cx/inlinelogging/) in this library and modify it to suit your needs. 

