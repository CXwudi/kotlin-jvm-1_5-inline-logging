@file:Suppress("NOTHING_TO_INLINE")

package mikufan.cx.inlinelogging

import org.slf4j.Logger
import org.slf4j.Marker


/**
 * Kotlin 1.5 value class of [Logger] with inline logging method
 *
 * Usage:
 * ```
 * logger.info { "an info log msg" }
 * ```
 * will be compiled to
 * ```
 * if (isTraceEnabled) {
 *   logger.info("an info log msg")
 * }
 * ```
 *
 * This class doesn't implement [Logger] interface in order to force users using the better inline logging methods.
 *
 * Also, this class doesn't implement any interface. Base on the [doc](https://kotlinlang.org/docs/inline-classes.html#representation),
 * any referencing type other than the class itself will be represented as the warped class, which breaks the benefit of inlining
 *
 * @date 2021-07-25
 * @author CX无敌
 */
@JvmInline
value class KInlineLogger(val underlyingLogger: Logger) {

  inline val isTraceEnabled: Boolean get() = underlyingLogger.isTraceEnabled

  inline val isDebugEnabled: Boolean get() = underlyingLogger.isDebugEnabled

  inline val isInfoEnabled: Boolean get() = underlyingLogger.isInfoEnabled

  inline val isWarnEnabled: Boolean get() = underlyingLogger.isWarnEnabled

  inline val isErrorEnabled: Boolean get() = underlyingLogger.isErrorEnabled

  inline fun isTraceEnabled(marker: Marker?): Boolean = underlyingLogger.isTraceEnabled(marker)

  inline fun isDebugEnabled(marker: Marker?): Boolean = underlyingLogger.isDebugEnabled(marker)

  inline fun isInfoEnabled(marker: Marker?): Boolean = underlyingLogger.isInfoEnabled(marker)

  inline fun isWarnEnabled(marker: Marker?): Boolean = underlyingLogger.isWarnEnabled(marker)

  inline fun isErrorEnabled(marker: Marker?): Boolean = underlyingLogger.isErrorEnabled(marker)

  inline val name: String get() = underlyingLogger.name

  inline fun trace(msg: () -> Any?) {
    if (isTraceEnabled) {
      underlyingLogger.trace(msg().toString())
    }
  }

  inline fun trace(t: Throwable?, msg: () -> Any?) {
    if (isTraceEnabled) {
      underlyingLogger.trace(msg().toString(), t)
    }
  }

  inline fun trace(marker: Marker?, msg: () -> Any?) {
    if (isTraceEnabled(marker)) {
      underlyingLogger.trace(marker, msg().toString())
    }
  }

  inline fun trace(marker: Marker?, t: Throwable?, msg: () -> Any?) {
    if (isTraceEnabled(marker)) {
      underlyingLogger.trace(marker, msg().toString(), t)
    }
  }

  inline fun debug(msg: () -> Any?) {
    if (isDebugEnabled) {
      underlyingLogger.debug(msg().toString())
    }
  }

  inline fun debug(t: Throwable?, msg: () -> Any?) {
    if (isDebugEnabled) {
      underlyingLogger.debug(msg().toString(), t)
    }
  }

  inline fun debug(marker: Marker?, msg: () -> Any?) {
    if (isDebugEnabled(marker)) {
      underlyingLogger.debug(marker, msg().toString())
    }
  }

  inline fun debug(marker: Marker?, t: Throwable?, msg: () -> Any?) {
    if (isDebugEnabled(marker)) {
      underlyingLogger.debug(marker, msg().toString(), t)
    }
  }

  inline fun info(msg: () -> Any?) {
    if (isInfoEnabled) {
      underlyingLogger.info(msg().toString())
    }
  }

  inline fun info(t: Throwable?, msg: () -> Any?) {
    if (isInfoEnabled) {
      underlyingLogger.info(msg().toString(), t)
    }
  }

  inline fun info(marker: Marker?, msg: () -> Any?) {
    if (isInfoEnabled(marker)) {
      underlyingLogger.info(marker, msg().toString())
    }
  }

  inline fun info(marker: Marker?, t: Throwable?, msg: () -> Any?) {
    if (isInfoEnabled(marker)) {
      underlyingLogger.info(marker, msg().toString(), t)
    }
  }

  inline fun warn(msg: () -> Any?) {
    if (isWarnEnabled) {
      underlyingLogger.warn(msg().toString())
    }
  }

  inline fun warn(t: Throwable?, msg: () -> Any?) {
    if (isWarnEnabled) {
      underlyingLogger.warn(msg().toString(), t)
    }
  }

  inline fun warn(marker: Marker?, msg: () -> Any?) {
    if (isWarnEnabled(marker)) {
      underlyingLogger.warn(marker, msg().toString())
    }
  }

  inline fun warn(marker: Marker?, t: Throwable?, msg: () -> Any?) {
    if (isWarnEnabled(marker)) {
      underlyingLogger.warn(marker, msg().toString(), t)
    }
  }

  inline fun error(msg: () -> Any?) {
    if (isErrorEnabled) {
      underlyingLogger.error(msg().toString())
    }
  }

  inline fun error(t: Throwable?, msg: () -> Any?) {
    if (isErrorEnabled) {
      underlyingLogger.error(msg().toString(), t)
    }
  }

  inline fun error(marker: Marker?, msg: () -> Any?) {
    if (isErrorEnabled(marker)) {
      underlyingLogger.error(marker, msg().toString())
    }
  }

  inline fun error(marker: Marker?, t: Throwable?, msg: () -> Any?) {
    if (isErrorEnabled(marker)) {
      underlyingLogger.error(marker, msg().toString(), t)
    }
  }
//  
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("trace { msg }"))
//  override fun trace(msg: String?) {
//    underlyingLogger.trace(msg)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("trace(t) { msg }"))
//  override fun trace(msg: String?, t: Throwable?) {
//    underlyingLogger.trace(msg, t)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("trace(marker) { msg }"))
//  override fun trace(marker: Marker?, msg: String?) {
//    underlyingLogger.trace(marker, msg)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("trace(marker, t) { msg }"))
//  override fun trace(marker: Marker?, msg: String?, t: Throwable?) {
//    underlyingLogger.trace(marker, msg, t)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("trace { msg }"))
//  override fun trace(format: String?, arg: Any?) {
//    underlyingLogger.trace(format, arg)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("trace { msg }"))
//  override fun trace(format: String?, arg1: Any?, arg2: Any?) {
//    underlyingLogger.trace(format, arg1, arg2)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("trace { msg }"))
//  override fun trace(format: String?, vararg arguments: Any?) {
//    underlyingLogger.trace(format, *arguments)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("trace(marker) { msg }"))
//  override fun trace(marker: Marker?, format: String?, arg: Any?) {
//    underlyingLogger.trace(marker, format, arg)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("trace(marker) { msg }"))
//  override fun trace(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
//    underlyingLogger.trace(marker, format, arg1, arg2)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("trace(marker) { msg }"))
//  override fun trace(marker: Marker?, format: String?, vararg arguments: Any?) {
//    underlyingLogger.trace(marker, format, *arguments)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("debug { msg }"))
//  override fun debug(msg: String?) {
//    underlyingLogger.debug(msg)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("debug(t) { msg }"))
//  override fun debug(msg: String?, t: Throwable?) {
//    underlyingLogger.debug(msg, t)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("debug(marker) { msg }"))
//  override fun debug(marker: Marker?, msg: String?) {
//    underlyingLogger.debug(marker, msg)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("debug(marker, t) { msg }"))
//  override fun debug(marker: Marker?, msg: String?, t: Throwable?) {
//    underlyingLogger.debug(marker, msg, t)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("debug { msg }"))
//  override fun debug(format: String?, arg: Any?) {
//    underlyingLogger.debug(format, arg)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("debug { msg }"))
//  override fun debug(format: String?, arg1: Any?, arg2: Any?) {
//    underlyingLogger.debug(format, arg1, arg2)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("debug { msg }"))
//  override fun debug(format: String?, vararg arguments: Any?) {
//    underlyingLogger.debug(format, *arguments)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("debug(marker) { msg }"))
//  override fun debug(marker: Marker?, format: String?, arg: Any?) {
//    underlyingLogger.debug(marker, format, arg)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("debug(marker) { msg }"))
//  override fun debug(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
//    underlyingLogger.debug(marker, format, arg1, arg2)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("debug(marker) { msg }"))
//  override fun debug(marker: Marker?, format: String?, vararg arguments: Any?) {
//    underlyingLogger.debug(marker, format, *arguments)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("info { msg }"))
//  override fun info(msg: String?) {
//    underlyingLogger.info(msg)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("info(t) { msg }"))
//  override fun info(msg: String?, t: Throwable?) {
//    underlyingLogger.info(msg, t)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("info(marker) { msg }"))
//  override fun info(marker: Marker?, msg: String?) {
//    underlyingLogger.info(marker, msg)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("info(marker, t) { msg }"))
//  override fun info(marker: Marker?, msg: String?, t: Throwable?) {
//    underlyingLogger.info(marker, msg, t)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("info { msg }"))
//  override fun info(format: String?, arg: Any?) {
//    underlyingLogger.info(format, arg)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("info { msg }"))
//  override fun info(format: String?, arg1: Any?, arg2: Any?) {
//    underlyingLogger.info(format, arg1, arg2)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("info { msg }"))
//  override fun info(format: String?, vararg arguments: Any?) {
//    underlyingLogger.info(format, *arguments)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("info(marker) { msg }"))
//  override fun info(marker: Marker?, format: String?, arg: Any?) {
//    underlyingLogger.info(marker, format, arg)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("info(marker) { msg }"))
//  override fun info(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
//    underlyingLogger.info(marker, format, arg1, arg2)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("info(marker) { msg }"))
//  override fun info(marker: Marker?, format: String?, vararg arguments: Any?) {
//    underlyingLogger.info(marker, format, *arguments)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("warn { msg }"))
//  override fun warn(msg: String?) {
//    underlyingLogger.warn(msg)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("warn(t) { msg }"))
//  override fun warn(msg: String?, t: Throwable?) {
//    underlyingLogger.warn(msg, t)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("warn(marker) { msg }"))
//  override fun warn(marker: Marker?, msg: String?) {
//    underlyingLogger.warn(marker, msg)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("warn(marker, t) { msg }"))
//  override fun warn(marker: Marker?, msg: String?, t: Throwable?) {
//    underlyingLogger.warn(marker, msg, t)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("warn { msg }"))
//  override fun warn(format: String?, arg: Any?) {
//    underlyingLogger.warn(format, arg)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("warn { msg }"))
//  override fun warn(format: String?, arg1: Any?, arg2: Any?) {
//    underlyingLogger.warn(format, arg1, arg2)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("warn { msg }"))
//  override fun warn(format: String?, vararg arguments: Any?) {
//    underlyingLogger.warn(format, *arguments)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("warn(marker) { msg }"))
//  override fun warn(marker: Marker?, format: String?, arg: Any?) {
//    underlyingLogger.warn(marker, format, arg)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("warn(marker) { msg }"))
//  override fun warn(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
//    underlyingLogger.warn(marker, format, arg1, arg2)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("warn(marker) { msg }"))
//  override fun warn(marker: Marker?, format: String?, vararg arguments: Any?) {
//    underlyingLogger.warn(marker, format, *arguments)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("error { msg }"))
//  override fun error(msg: String?) {
//    underlyingLogger.error(msg)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("error(t) { msg }"))
//  override fun error(msg: String?, t: Throwable?) {
//    underlyingLogger.error(msg, t)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("error(marker) { msg }"))
//  override fun error(marker: Marker?, msg: String?) {
//    underlyingLogger.error(marker, msg)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("error(marker, t) { msg }"))
//  override fun error(marker: Marker?, msg: String?, t: Throwable?) {
//    underlyingLogger.error(marker, msg, t)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("error { msg }"))
//  override fun error(format: String?, arg: Any?) {
//    underlyingLogger.error(format, arg)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("error { msg }"))
//  override fun error(format: String?, arg1: Any?, arg2: Any?) {
//    underlyingLogger.error(format, arg1, arg2)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("error { msg }"))
//  override fun error(format: String?, vararg arguments: Any?) {
//    underlyingLogger.error(format, *arguments)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("error(marker) { msg }"))
//  override fun error(marker: Marker?, format: String?, arg: Any?) {
//    underlyingLogger.error(marker, format, arg)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("error(marker) { msg }"))
//  override fun error(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
//    underlyingLogger.error(marker, format, arg1, arg2)
//  }
//
//  @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("error(marker) { msg }"))
//  override fun error(marker: Marker?, format: String?, vararg arguments: Any?) {
//    underlyingLogger.error(marker, format, *arguments)
//  }
}