package T03_collections

// by default - collection types are immutable
fun main() {
    // ------------- ARRAY ----------------
    val someArray = arrayOf("Kotlin", "Programming", "Comic Books")


    // ------------- LIST ----------------
    // unmutable - cant change, add , remove...
    val listOfThings = listOf("Kotlin", "Programming", "Comic Books")

    //m,utable - can add .. .etc
    val mutableList = mutableListOf("Kotlin", "Programming", "Comic Books")
    mutableList.add("Dogs")

    // ------------- MAP ----------------
    val map = mapOf( 1 to "a", 2 to "b", 3 to "c")
    map.forEach() { key, value ->
        println("$key -> $value")
    }

    val mutableMap = mutableMapOf( 1 to "a", 2 to "b", 3 to "c")
    mutableMap.put(4, "d")
}