package mikufan.cx.inlinelogging

import io.kotest.core.spec.style.ShouldSpec
import kotlinx.coroutines.delay
import mu.KotlinLogging

const val warmupCount = 200
const val loopCount = 2000

class KInlineLoggingPerformanceTest : ShouldSpec({
  context("kotlin 1.5 inline logging") {
    inlineLogger.info { "please attach profiler" }
    delay(5_000L)
    val testFun: (Int, String) -> Unit = { count, msg ->
      for (i in 0 until count) {
        inlineLogger.error { "$msg error $i" }
        inlineLogger.warn { "$msg warn $i" }
        inlineLogger.info { "$msg info $i" }
        inlineLogger.debug { "$msg debug $i" }
        inlineLogger.trace { "$msg trace $i" }
      }
    }
    testFun(warmupCount, "warmup")
    should("run really fast with less memory") {
      testFun(loopCount, "inline logger")
    }
    inlineLogger.info { "before end test 10s delay, to allow profiler takes enough data" }
    delay(6_000L)
  }
})

class KNoinlineLoggingPerformanceTest : ShouldSpec({
  context("kotlin noinline logging") {
    noinlineLogger.info { "please attach profiler" }
    delay(5_000L)
    val testFun: (Int, String) -> Unit = { count, msg ->
      for (i in 0 until count) {
        noinlineLogger.error { "$msg error $i" }
        noinlineLogger.warn { "$msg warn $i" }
        noinlineLogger.info { "$msg info $i" }
        noinlineLogger.debug { "$msg debug $i" }
        noinlineLogger.trace { "$msg trace $i" }
      }
    }
    testFun(warmupCount, "warmup")
    should("run slower with more memory") {
      testFun(loopCount, "noinline logger")
    }
    noinlineLogger.info { "before end test 10s delay, to allow profiler takes enough data" }
    delay(6_000L)
  }
})

private val inlineLogger = KInlineLogging.logger()
private val noinlineLogger = KotlinLogging.logger {}
//KotlinlineLogging

// the result is: performance is negligible, maybe inline logger is slightly faster