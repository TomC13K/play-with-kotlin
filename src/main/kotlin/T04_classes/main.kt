package T04_classes

fun main() {
    val personEmpty = PersonEmptyClass()

    val person = Person("first", "last")      // kotlin doesnt require new keyword to create instance of class
    println(person.lastName)                 // kotlin doesnt require setters and getters

    // secondary constructor class
    // not really neccessary when using default paramter values
    val personSecond = PersonSecond()        // secondary constructor runs when no paramteres are provided, init blocks always run before secondary constructor
    println(personSecond.firstName)
    println(personSecond.lastName)


    // properties
    val personProperties = PersonProperties()
    println(personProperties.firstName)
    println(personProperties.lastName)
    personProperties.nickName = "oallaaaa"
    println(personProperties.nickName)
    personProperties.printInfo()
}

// ------------ ACCESS MODIFIERS ------------
// public      - by default
// internal    - visible inside the same module
// private     - visible inside the same file  - good if want block calling access from outside
// protected    - visible inside the same class and its subclasses  -good for class methods

