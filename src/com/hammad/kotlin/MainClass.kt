package com.hammad.kotlin

fun main() {

    val nullable: String?
    val notNullable: String
    val notSure: MutableList<String>? = mutableListOf<String>()
    notSure!!.add("hello") // !! will throw NullPointerException if the value is null
    notSure?.add("world ") // check if variable is null

//    samplaSwitch()

//    println(returnGreet("Hammad"))

//    println(sayHello())

//    testArray()

//    testList()

//    testMap()

//    testVararg("Hi","Hammad", "Faeez")

//    val names = arrayOf("Hammad", "Faeez")
//    testVararg("hi", *names) // Using * coz we cannot pass an array as vararg

//    testDifferentOrderArgument(age=25, name="hammad") // This is how we can pass values irrespective of order

//    // Testing Default Parameters
//    testDefaultParameter()
//    testDefaultParameter("Hammad")
//    testDefaultParameter("Hammad", 25)

//    // OOP
    val person = Person("Hammad")
    println(person._firstName)
    println(person._lastName)
    person.fullNameWithNickName()
    person.nickname = "iron man"
    println(person.nickname)
    person.fullNameWithNickName()
}

// Sample Code for Switch Statement
// Unit means function doesn't return or return non-important thing
fun samplaSwitch(): Unit {
    val expression = "Hammads"
    when (expression) {
        "Hammad" -> println("Hammad Here")
        "Faeez" -> println("Faeez")
        else -> println("Ibrahim Here")
    }
}

// Sample Function Getting Patameter and Return Parameter
fun returnGreet(name: String): String {
    return "hello $name"
}

// Single Expression Function
fun sayHello() = "Hello There"

fun testArray() {
    val array = arrayOf("Kotlin", "Programming", "Test")
    println()
    println(array.size)
    println()
    println(array[0])
    println()
    println(array.get(0))

    println()
    for(i in array) {
        println(i)
    }

    println()
    array.forEach {
        println(it)
    }

    println()
    array.forEach {item ->
        println(item)
    }

    println()
    array.forEachIndexed { index, item ->
        println("$item is at $index")
    }
}

fun testList() {

    val list = listOf("Kotlin", "Programming", "Test")

    // For Mutable List
    val mutableList = mutableListOf("Kotlin", "Programming", "Test")

    println()
    println(list.size)
    println()
    println(list[0])
    println()
    println(list.get(0))

    println()
    for(i in list) {
        println(i)
    }

    println()
    list.forEach {
        println(it)
    }

    println()
    list.forEach {item ->
        println(item)
    }

    println()
    list.forEachIndexed { index, item ->
        println("$item is at $index")
    }
}

fun testMap() {

    // key to value

    val map = mapOf(1 to "a", 2 to "b", 3 to "c")

    // For Mutable Map
    val mutableList = mutableMapOf(1 to "a", 2 to "b", 3 to "c")

    map.forEach { key, value ->
        println("$key to $value")
    }
}

// vararg keyword allow function caller to pass variable number of arguments when you use it.
// testVararg("Hi","Hammad", "Faeez") -> the way of calling it
fun testVararg(greeting: String, vararg names: String) {
    names.forEach { name ->
        println("$greeting $name")
    }
}

fun testDifferentOrderArgument(name: String, age: Number) {
    println("Name: $name, Age: $age")
}

fun testDefaultParameter(name: String = "Default Name", age: Number = 0) {
    println("Name: $name, Age: $age")
}