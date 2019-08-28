package local.jvm

import java.util.prefs.Preferences

internal class SafeLocalPreferences internal constructor(nativePreferences: Preferences) :
    LocalPreferences(nativePreferences) {

    override fun getShort(key: String): Short? = get(key)?.toShort()

    override fun getByte(key: String): Byte? = get(key)?.toByte()

    override fun set(key: String, value: Short) = set(key, value.toString())

    override fun set(key: String, value: Byte) = set(key, value.toString())
}