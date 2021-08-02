package mikufan.cx.inlinelogging

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.string.shouldEndWith

class KInlineLoggingTest : ShouldSpec({
  val targetClassName = "KInlineLoggingTest"

  context("logger class name") {
    should("be like Java class name") {
      logger1.info { "wowowow, inline logger 1" }
      logger1.name shouldEndWith targetClassName
    }

    should("be like Java class name in local") {
      val insideLogger = KInlineLogging.logger()
      insideLogger.info { "ohhh, inline logger local" }
      insideLogger.name shouldEndWith targetClassName
    }

    should("be like Java class name in lambda"){
      val func = {
        val insideLogger = KInlineLogging.logger()
        insideLogger.info { "ohhh, inline logger from lambda" }
        insideLogger.name shouldEndWith targetClassName
      }
      func()
    }

    should("be like Java class name in companion object"){
      logger2.info { "wowowow, inline logger 2 from companion object" }
      logger2.name shouldEndWith targetClassName
    }
  }
}) {
  companion object {
    private val logger2 = KInlineLogging.logger()
  }
}

private val logger1 = KInlineLogging.logger()
