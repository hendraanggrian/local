@file:Suppress("unused", "NOTHING_TO_INLINE")

package com.hendraanggrian.local.jvm

import com.hendraanggrian.local.Local
import com.hendraanggrian.local.LocalSaver
import com.hendraanggrian.local.WritableLocal
import java.io.File
import java.util.prefs.Preferences

fun Local.of(
    source: Preferences,
    useSimple: Boolean = false
): WritableLocal = when {
    useSimple -> SimpleLocalPreferences(source)
    else -> LocalPreferences(source)
}

fun Local.of(
    source: File,
    useSimple: Boolean = false
): WritableLocal = when {
    useSimple -> SimpleLocalProperties(source)
    else -> LocalProperties(source)
}

inline fun Local.bind(
    source: File,
    target: Any,
    useSimple: Boolean = false
): LocalSaver = bind(of(source, useSimple), target)

inline fun Local.bind(
    source: Preferences,
    target: Any,
    useSimple: Boolean = false
): LocalSaver = bind(of(source, useSimple), target)