package T05_interfaces

interface PersonInfoProvider {
    val providerInfo : String

    // in Kotlin interface can have implementation - in here this print wil always print when interface is implemented
    fun printInfo(person: Person) {
        println(providerInfo)            // encapsulation - providerInfo is called
        person.printInfo()
    }
}

// abstract class doesnt need to implement all the interfaces
// abstract CANT create an INSTANCE !!!
// abstract class BasicInfoProvider : PersonInfoProvider

class BasicInfoProvider : PersonInfoProvider {

    // now we only add value to providerInfo which interface will print
    override val providerInfo: String
        get() = "BasicInfoProvider"

    // override is keyword to override the function , otherwise error
    // not needed this as its implemented in the interface
//    override fun printInfo(person: Person) {
//        println("Hello print xxx")
//        person.printInfo()
//    }
}