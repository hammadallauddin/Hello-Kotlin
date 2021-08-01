package com.hammad.kotlin

import java.util.*

enum class SampleEnum {
    EASY, MEDIUM, HARD;

    fun getFormattedName() = name.lowercase().replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
}

object SampleEnumFactory {
    fun create(type: SampleEnum): String {
        return when(type) {
            SampleEnum.EASY -> type.name
            SampleEnum.MEDIUM -> type.getFormattedName()
            SampleEnum.HARD -> "hard"
        }
    }
}

fun main() {
    println(SampleEnumFactory.create(SampleEnum.HARD))
}