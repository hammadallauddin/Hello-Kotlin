package com.hammad.kotlin

class Person(val _firstName: String, val _lastName: String) {

// ALTERNATE WAYS OF VALUE ASSIGNMENT
//    val frstName: String = _firsName
//    val lastName: String = _lastName
//     Above work can be done by using init as done below
//    var fn: String
//    var ln: String
//    init {
//        fn = _firsName
//        ln = _lastName
//    }

// WORKING FOR SECONDARY CONSTRUCTOR
    init {
        println("init 1")
    }
    constructor(): this(_firstName = "", _lastName = "") {
        println("secondary constructor 1")
    }

    constructor(_firstName: String): this(_firstName = _firstName, _lastName = "") {
        println("secondary constructor 2")
    }

    init {
        println("init 2")
    }

    // OTHER NULLABLE VARIABLE
    var nickname: String? = null
    set(value) {
        field = value
        println("Nickname value set")
    }
    get() {
        println("Nickname value get")
        return field
    }

    fun fullNameWithNickName() {
        val nickNameToBe = nickname ?: "No NickName" // ?: use to check if value is not null else return value after expression
        println("Full Name: $_firstName $_lastName. NickName: $nickNameToBe")
    }
}