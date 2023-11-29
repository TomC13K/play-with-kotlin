package T01_basics

// constant
val name: String = "name"

// variable - non-null by default
var greetingA : String = ""
var greeting = "hello greeting"

//nullable
var someNullString: String? = null

fun main() {
    println(greeting)
    println(name)             // print constant

    someNullString = "not Null  stringyyyyy"
    if (someNullString != null) {
        println(someNullString)
    } else {
        println("someNullString is null")
    }



    // same as if else - kinda substitute for switch
    when (someNullString) {
        null -> println("someNullString is null")
        else -> println(someNullString)
    }

    // assign value on lofical expression
    val stringVar = if (greeting != null) greeting else "olaaa null"

    val stringVar2 = when (greeting) {
        null -> "olaaa when null"
        else -> greeting
    }

    println(stringVar)
    println(stringVar2)
}