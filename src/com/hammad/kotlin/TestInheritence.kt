package com.hammad.kotlin

// open keyword says that other class can now inherit from that class
open class FancyInfoProvider {

    val parentVal: String = "Parent Val"
    open val inheritanceVal: String = "Inheritance Val"

    fun parentFun() {
        println("Parent Class Function")
    }

    open fun inheritanceFun() {
        println("This function is in parent class")
    }
}

class InheritenceProvider : FancyInfoProvider() {

    override val inheritanceVal: String
        get() = "Updated Val"

    override fun inheritanceFun() {
        println("This function is in child class")
    }
}

fun main() {
    val temp = InheritenceProvider()
    temp.parentFun()
    temp.inheritanceFun()
    println(temp.inheritanceVal)
}