package com.hendraanggrian.lokal.internal

import com.hendraanggrian.lokal.Lokal
import com.hendraanggrian.lokal.ReadableLokal

/** Parent class of any class generated by `lokal-compiler`. */
abstract class LokalBinding(private val source: ReadableLokal) : Lokal.Saver {

    protected fun get(key: String, defaultValue: String?): String? =
        source[key] ?: defaultValue

    protected fun get(key: String, defaultValue: Boolean): Boolean =
        source.getBoolean(key) ?: defaultValue

    protected fun get(key: String, defaultValue: Double): Double =
        source.getDouble(key) ?: defaultValue

    protected fun get(key: String, defaultValue: Float): Float =
        source.getFloat(key) ?: defaultValue

    protected fun get(key: String, defaultValue: Long): Long =
        source.getLong(key) ?: defaultValue

    protected fun get(key: String, defaultValue: Int): Int =
        source.getInt(key) ?: defaultValue

    protected fun get(key: String, defaultValue: Short): Short =
        source.getShort(key) ?: defaultValue

    protected fun get(key: String, defaultValue: Byte): Byte =
        source.getByte(key) ?: defaultValue

    /**
     * Get editor instance from source lokal. Some lokal may need to open instance, while
     * simple lokal already implements editor
     *
     * @throws IllegalStateException unsupported behavior, contact `github.com/hendraanggrian/lokal/issues`
     */
    protected fun getEditor(): Lokal.Editor = when (source) {
        is Lokal -> source.getEditor()
        is Lokal.Editor -> source
        else -> throw IllegalStateException()
    }
}