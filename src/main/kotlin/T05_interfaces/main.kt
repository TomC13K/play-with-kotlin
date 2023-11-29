package T05_interfaces

fun main () {
    val provider = BasicInfoProvider()
    provider.printInfo(Person())           // pass in empty instance of Person
}