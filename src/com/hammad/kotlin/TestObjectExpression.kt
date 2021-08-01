package com.hammad.kotlin

open class SampleClass {
    open fun sampleFunction() {
        println("This is sample function")
    }
}

fun main() {
    val temp = object : SampleClass() {
        override fun sampleFunction() {
            println("Overridden function")
        }
    }

    temp.sampleFunction()
}