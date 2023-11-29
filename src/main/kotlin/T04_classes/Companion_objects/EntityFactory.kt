package T04_classes.Companion_objects

// factory to create instances of Entity

interface IdProvider {
    fun getId(): String
}
class Entity private constructor(val id: String) {

        // companion object can implement interfaces as standard class
        companion object Factory: IdProvider {
            const val id = "id"

            fun create() = Entity(id)

            override fun getId(): String {
                return "123"
            }
        }

}


fun main() {
    // val entity = Entity("id")          - cant just use this because the init n constructor are private now
    val entity = Entity.create()
    println(Entity.id)
    println(Entity.getId())
    println(entity.id)
}