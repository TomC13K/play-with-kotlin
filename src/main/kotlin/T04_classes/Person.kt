package T04_classes

// can create completely empty class with this syntax which will have default constructor because it has no parameters
class PersonEmptyClass





// simple class definition with constructor parameters , because kotlin adds getters and setters automatically
// same as class above but much less written code
class Person(val firstName: String, val lastName: String)





// the empty brackets are constructor     class Person constructor()
class PersonLong(_firstName: String, _lastName: String) {
    val firstName : String = _firstName                   //syntax with type
    val lastName = _lastName

    // init block is executed each time when class is instantiated
    // dont need init if using the constructor syntax above   var firstName = _firstName
    /*
    init {
        firstName = _firstName
        lastName = _lastName
    }
    */
}






