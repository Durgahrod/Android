package com.example.myapplication;

import kotlin.text.Regex;

class Person (fName: String, personAge: Int){
    val firstName: String
    var age: Int

    init {

        if(!checkName(fName)) throw UnsupportedOperationException()

        firstName = fName.capitalize()
        age = personAge

        println("Person created: ${toString()}")
    }

    private fun checkName(fName: String): Boolean{
        if (fName == null || fName?.isBlank() == true) false

        var reg = Regex("[A-Za-z]+")

        return reg.matches(fName)
    }

    override fun toString() = "$firstName is $age years old"

    fun loopIt(){
        var items = listOf("Yann", "Alexandre", "Guillaume")
        for (item in items) {
            println(item)
        }
    }
}
