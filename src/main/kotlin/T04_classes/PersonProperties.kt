package T04_classes

class PersonProperties(val firstName: String = "Jane", val lastName: String = "Doe")  {

    // var can assign value
    var nickName: String? = null
        set(value) {
            field = value                           // field is a special keyword that refers to the backing field
            println("the new nickname is $value")   // when updated, it will print this log message
        }
        get() {
            println("the returned value is $field")  // when getting the value out, again it will log this to console
            return field
        }

    fun printInfo() {
        // val nickNameToPrintOld = if(nickName != null) nickName else "no nickname"

        val nickNameToPrint = nickName ?: "no nickname"  // elvis operator simpler to check null condition
        println("$firstName ($nickNameToPrint) $lastName")
    }
}