package com.hammad.kotlin

class Entity private constructor(var id: Int) {
    companion object {
        fun create() = Entity(1)
    }


   fun increment() {
       id += 1
   }

   @JvmName("getId1")
   fun getId(): Int {
       return id
   }
}


fun main() {
    var temp = Entity.create()
    temp.increment()
    println(temp.getId())
    temp.increment()
    println(temp.getId())
}