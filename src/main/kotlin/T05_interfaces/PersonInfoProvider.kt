package T05_interfaces

interface PersonInfoProvider {
    val providerInfo : String

    // in Kotlin interface can have implementation - in here this print wil always print when interface is implemented
    fun printInfo(person: Person) {
        println(providerInfo)            // encapsulation - providerInfo is called
        person.printInfo()
    }
}

interface SessionInfoProvider {
    fun getSessionId() : String
}

// abstract class doesnt need to implement all the interfaces
// abstract CANT create an INSTANCE !!!
// abstract class BasicInfoProvider : PersonInfoProvider

// open - keyword means we can inherit from this class !!!!
open class BasicInfoProvider : PersonInfoProvider, SessionInfoProvider {

    // protected so its available inside inherited classes, open so it can be overwritten but not fully public
    protected open val sessionIdPrefix = "Session"

    // now we only add value to providerInfo which interface will print
    override val providerInfo: String
        get() = "BasicInfoProvider"

    // override is keyword to override the function , otherwise error
    // not needed this as its implemented in the interface
//    override fun printInfo(person: Person) {
//        println("Hello print xxx")
//        person.printInfo()
//    }

// super will use default in interface plus this overwritten function too
    override fun printInfo(person: Person) {
        super.printInfo(person)
        println("additional print statement")
    }

    override fun getSessionId(): String {
        return sessionIdPrefix
    }
}