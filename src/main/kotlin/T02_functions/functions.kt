package T02_functions

fun getGreeting(): String? {
    return "Hello Kotlin"
}
// Single expression function syntax - for simple return
fun getGreeting1() : String = "Hello Kotlin 1"
fun getGreeting2() = "Hello Kotlin 2"


// unit - if function doesnt return any return type - THIS CAN BE OMITTED like on main()
fun sayHello() : Unit {
    println(getGreeting())
}

fun passParams( item : String) {
    val msg1 = "Value " + item
    val msg = "Hello $item function"
    println(msg)
}

// change to single expression function
fun passParams1( item : String) = println("Hello $item function single")

fun sayHelloArray(greeting : String, itemToGreet  :String)  = println("$greeting $itemToGreet")

fun sayHelloList( greeting: String, itemsToGreet: List<String>){
    itemsToGreet.forEach { itemToGreet ->
        println("$greeting $itemToGreet")
    }
}

fun main() {
    println(getGreeting())
    println(getGreeting1())
    println(getGreeting2())
    sayHello()

    passParams("Hello")
    passParams1("Hello")

    val interestingThings = arrayOf("Kotlin", "Programming", "Comic Books")
    interestingThings.forEach { interestingThing ->
        println(interestingThing)
    }
    interestingThings.forEachIndexed() { index, interestingThing ->
        println("$interestingThing is at index $index")
    }

    val listOgThings = listOf("Kotlin", "Programming", "Comic Books")
    sayHelloList("Hi", listOgThings)

}