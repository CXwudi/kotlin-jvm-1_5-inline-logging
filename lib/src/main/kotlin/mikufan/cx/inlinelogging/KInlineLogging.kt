@file:Suppress("NOTHING_TO_INLINE")
package mikufan.cx.inlinelogging

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.lang.invoke.MethodHandles
import kotlin.reflect.KClass

/**
 * @date 2021-07-26
 * @author CX无敌
 */
object KInlineLogging {
  inline fun logger(): KInlineLogger {
    val delegate = LoggerFactory.getLogger(KInlineLoggerNameResolver.fixName(MethodHandles.lookup().lookupClass()))
    return KInlineLogger(delegate)
  }

  inline fun logger(name: String): KInlineLogger {
    val delegate = LoggerFactory.getLogger(name)
    return KInlineLogger(delegate)
  }

  inline fun <T : Any> logger(clazz: KClass<T>): KInlineLogger {
    val delegate = LoggerFactory.getLogger(KInlineLoggerNameResolver.fixName(clazz.java))
    return KInlineLogger(delegate)
  }

  inline fun logger(underlyingLogger: Logger): KInlineLogger = KInlineLogger(underlyingLogger)
}


object KInlineLoggerNameResolver {
  /**
   * get class name for java class (that usually represents kotlin class)
   */
  fun <T> fixName(clazz: Class<T>): String = clazz.toSlicedName()

  private inline fun <T> Class<T>.toSlicedName(): String = when {
    name.contains("Kt$") -> name.substringBefore("Kt$")
    name.contains("$") -> name.substringBefore("$")
    // In case Kt appears in the middle, so using endWith()
    name.endsWith("Kt") -> name.substring(0, name.length - 2)
    else -> name
  }
}
