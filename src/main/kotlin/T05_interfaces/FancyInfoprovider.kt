package T05_interfaces


// Inherit from base class
class FancyInfoprovider :BasicInfoProvider(){

    override val sessionIdPrefix: String
        get() = "Fancy session"

        override val providerInfo: String
            //get() = super.providerInfo
            get() = "Fancy Info Provider"

        override fun printInfo(person: Person) {
            super.printInfo(person)
            println("Fancy Info")
        }
}