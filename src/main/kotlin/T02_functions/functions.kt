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

// default values syntax
fun sayHello(greeting : String = "One", itemToGreet  :String = "Two")  = println("$greeting $itemToGreet")

fun sayHelloList( greeting: String, itemsToGreet: List<String>){
    itemsToGreet.forEach { itemToGreet ->
        println("$greeting $itemToGreet")
    }
}

// vararg - variable number of strings can be 0 n use only first argument or can add many more strings
fun varargStrings( greeting: String, vararg itemsToGreet :String){
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

    //----------------- vararg -----------------
    varargStrings("var 1")
    varargStrings("var 2", "Kotlin")
    varargStrings("var 3", "Kotlin", "Programming", "Comic Books")

    // pass array to vararg
    // it requires string not Array so use spread operator *, where we iterate over array n pass each string element
    varargStrings("var 4", *interestingThings)

    // ----------------- named arguments -----------------
    sayHello(greeting = "Hi", itemToGreet = "somethin")
    sayHello()  //using both default values without arguments

    // when using named argument, all arguments passed must be named not just one
    // with named variables we can switch order
    varargStrings(itemsToGreet = interestingThings, greeting = "Hi")

}