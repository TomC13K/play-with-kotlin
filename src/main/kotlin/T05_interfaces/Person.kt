package T05_interfaces

class Person(val firstName: String = "Jane", val lastName: String = "Doe")  {


    var nickName: String? = null

    fun printInfo() {
        val nickNameToPrint = nickName ?: "no nickname"
        println("$firstName ($nickNameToPrint) $lastName")
    }
}