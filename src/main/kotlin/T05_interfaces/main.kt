package T05_interfaces

fun main () {
    //val provider = BasicInfoProvider()      // standard instantiation
    val provider1 = FancyInfoprovider()        // instantiate the class that inheritted from the BasicInfoProvider
    provider1.printInfo(Person())              // pass in empty instance of Person
    provider1.getSessionId()

    checkTypes(provider1)



    // ----------  instantiate anonymous object class -----------
    // expression is     object : <namo of the class we want to extend
    // can be used as click listener for android
    val provider2 = object : PersonInfoProvider {
        override val providerInfo: String
            get() = "New Info Provider"

        fun getSessionId() = "id"
    }

    provider2.printInfo(Person())
    provider2.getSessionId()

}

fun checkTypes(infoProvider: PersonInfoProvider) {
    if (infoProvider !is SessionInfoProvider) {
        println("is not a session info provider")
    } else {
        println("is a session info provider")
        // smart cast
        // infoProvider.getSessionId() // this will not work as it is not smart cast
        // as is a keyword when casting to another type, now can call anything specific to seccionProvider
        // (infoProvider as SessionInfoProvider).getSessionId()
        // or
        infoProvider.getSessionId()
    }
}