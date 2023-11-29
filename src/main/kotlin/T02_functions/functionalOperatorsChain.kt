package T02_functions

fun main() {
    val list = listOf("Kotlin", "Java", "C++", "Javascript", null, null)

    list
        .filterNotNull()                       // filter first nulls and later down there are not nulls in the list
        .filter{
            it.startsWith("J")
        }
        .map {
            it.length
        }
        .forEach{
            println(it)
        }

    list
        .filterNotNull()
        .take(3)                             // takes first 3 elements  or takeLast(3)
        .forEach{
            println(it)
        }

    list
        .filterNotNull()
        .associate {                    // iterating over map entries of a string and int
            it to it.length
        }
        .forEach{
            println("${it.value}, ${it.key}")
        }

    // assign result to a variable
    val map = list
        .filterNotNull()
        .associate {                    // iterating over map entries of a string and int
            it to it.length
        }
    println(map)


    // pull out values from list
    val language = list.first()
    val languageLast = list.filterNotNull().last()
    val languageStartsWith = list.filterNotNull().find{it.startsWith("Java")}
    val languageLastStartsWith = list.filterNotNull().findLast{it.startsWith("Java")}
    val languageNonExistant = list.filterNotNull().findLast{it.startsWith("olallalaa")}.orEmpty()  //dont get null, just ""
    println(language)
    println(languageLast)
    println(languageStartsWith)
    println(languageLastStartsWith)
    println(languageNonExistant)
}