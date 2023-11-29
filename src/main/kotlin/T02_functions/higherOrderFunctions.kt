package T02_functions

// Higher order function that either return another functio nor takes a function as a parameter
//                             syntax   function name : (type passed to another function) -> return type
fun printFilterStrings(list: List<String>, predicate: ((String) -> Boolean)?) {
    list.forEach {
        //if (predicate(it)) {                 // we calling here functio nas usually with param if not null type
        if (predicate?.invoke(it) == true) {   //safe invode call on predicate function
            println(it)
        }
    }
}

// -----------------functional types -----------------
// store function as variable
val predicate: (String) -> Boolean = {
    it.startsWith("J")
}

// ----------------- function that returns function -----------------
fun getPrintPredicate(): (String) -> Boolean {
    return { it.startsWith("J") }
}

fun main() {
    val list = listOf("Kotlin", "Java", "C++", "Javascript")

    // printFilterStrings(list, {it.startsWith( "K")})
    // if last param is functio nwe can specify it  outside of the body
    // passing the predicate as lmabda
    printFilterStrings(list) {
        it.startsWith("K")
    }

    //passing predicate directly  thanks to functional type declared above
    printFilterStrings(list, predicate)

    // returning function from function
    printFilterStrings(list, getPrintPredicate())



    //passing null
    printFilterStrings(list, null)
}