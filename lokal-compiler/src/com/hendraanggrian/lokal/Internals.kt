package com.hendraanggrian.lokal

import com.google.auto.common.MoreElements
import com.squareup.javapoet.ClassName
import javax.lang.model.element.TypeElement

internal val TYPE_LOKAL_BINDING: ClassName =
    ClassName.get("com.hendraanggrian.lokal.internal", "LokalBinding")
internal val TYPE_READABLE_LOKAL: ClassName =
    ClassName.get("com.hendraanggrian.lokal", "ReadableLokal")
internal val TYPE_LOKAL_EDITOR: ClassName =
    ClassName.get("com.hendraanggrian.lokal", "Lokal").nestedClass("Editor")

internal const val TARGET = "target"
internal const val SOURCE = "source"
internal val EDITOR = TYPE_LOKAL_EDITOR.simpleName()

internal val TypeElement.measuredName: String
    get() {
        val enclosings = mutableListOf(simpleName.toString())
        var typeElement = this
        while (typeElement.nestingKind.isNested) {
            typeElement = MoreElements.asType(typeElement.enclosingElement)
            enclosings.add(typeElement.simpleName.toString())
        }
        enclosings.reverse()
        var typeName = enclosings[0]
        for (i in 1 until enclosings.size) typeName += "$${enclosings[i]}"
        return "$typeName${BindLokal.SUFFIX}"
    }