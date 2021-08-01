package com.hammad.kotlin

// empty Interface is valid and can be used as marker interface
interface PersonInfoProvider {

    val personName: String

    fun printInfo(infoString: String)

    fun personInfo() {
        println("This is person Info Provider")
    }

    fun printPersonName() {
        println("This is person name $personName")
    }
}

interface SessionInfoProvider {
    fun getSessionId() {
        println("Session Id is 5")
    }
}

class BasicInfoProvider : PersonInfoProvider, SessionInfoProvider {
    override val personName: String
        get() = "Hammad"

    override fun printInfo(infoString: String) {
        println("Info is $infoString")
    }
}

fun main() {
    val basicInfoProvider = BasicInfoProvider()
    basicInfoProvider.printInfo("hammad")
    basicInfoProvider.personInfo()
    basicInfoProvider.printPersonName()

    if(basicInfoProvider is SessionInfoProvider)
        basicInfoProvider.getSessionId()
    else
        println("Not Session Info Provider")

    (basicInfoProvider as SessionInfoProvider).getSessionId()
}