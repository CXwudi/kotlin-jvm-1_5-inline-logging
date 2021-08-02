# Kotlin/JVM 1.5 Inline Logging
[![](https://jitpack.io/v/CXwudi/kotlin-jvm-1_5-inline-logging.svg)](https://jitpack.io/#CXwudi/kotlin-jvm-1_5-inline-logging)

Powered by SLF4J, fully inlined, and say goodbye to lambda object creation 😲

## How to import

Visit [JitPack](https://jitpack.io/#CXwudi/kotlin-jvm-1_5-inline-logging)

## How to use
Example:
```kotlin
private val logger = KInlineLogging.logger() // an instance of the value class, KInlineLogger

class MainApp {
  fun start() {
    logger.info { "an info msg" }
    val exception = SomeException()
    logger.warn(exception) { "an warn msg with exception $exception" }
  }
}
```
Under the hook, this should be compiled as:
```kotlin
private val logger: Logger = LoggerFactory.getLogger(
  KInlineLoggerNameResolver.fixName(MethodHandles.lookup().lookupClass())
) // A SLF4J Logger

class MainApp {
  fun start() {
    if (logger.isInfoEnabled()){
      logger.info("an info msg") // no lambda object created 😊
    }
    val exception = SomeException()
    if (logger.isWarnEnabled()){
      logger.warn("an warn msg with exception $exception") // notice that this string creation will not happen if warn level is not enabled
    } 
  }
}
```

## Q: Can you support multi-platform?

A: Sorry, I am not supporting it, but you can just grab the only two source files in this library and modify it to suit your needs. 

