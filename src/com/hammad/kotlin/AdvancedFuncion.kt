package com.hammad.kotlin

fun printFilteredString(list: List<String>, predicate: (String) -> Boolean) {
    list.forEach {
        if (predicate(it)) {
            println(it)
        }
    }
}

fun predicateFunction(name: String): Boolean {
    return name.length > 5
}

val anotherPredicateFunction: (String) -> Boolean = {
    it.length <= 5
}

fun main() {
    val list = listOf("Hammad", "Allauddin", "Faeez", "Ali")
    printFilteredString(list) {
        predicateFunction(it)
    }

    println()

    printFilteredString(list, anotherPredicateFunction)
}