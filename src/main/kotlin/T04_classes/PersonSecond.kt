package T04_classes

// Secondary constructor
class PersonSecond(val firstName: String, val lastName: String) {

    init {
        println("Init block")
    }

    constructor(): this("John", "Doe") {     // need to satisty any parameters of primary constructor
        // body of secondary constructor
        println("Secondary constructor")
    }

    init {
        println("Init block 2")
    }
}