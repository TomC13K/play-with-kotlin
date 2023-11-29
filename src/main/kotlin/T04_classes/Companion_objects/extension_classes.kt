package T04_classes.Companion_objects

import java.util.*

// DATA CLASSES have their own generated hash codes so if they are different values they will not be equal ofc
enum class Entity5Type {
    HELP, EASY, MEDIUM, HARD;

    fun geFormattedName() = name.lowercase()
        .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
}


object Entity5Factory {
    fun create( type: Entity5Type) : Entity5 {
        val id = UUID.randomUUID().toString()
        val name = when(type) {
            Entity5Type.HELP -> type.name
            Entity5Type.EASY -> type.name
            Entity5Type.MEDIUM -> type.geFormattedName()
            Entity5Type.HARD -> "Hard"
        }
        return when(type) {
            Entity5Type.HELP -> Entity5.Help
            Entity5Type.EASY -> Entity5.Easy(id, name)
            Entity5Type.MEDIUM -> Entity5.Medium(id, name)
            Entity5Type.HARD -> Entity5.Hard(id, name, 2.0f)
        }
    }
}

sealed class Entity5 () {
    object Help : Entity5(){
        val name = "Help"
    }

    data class Easy(val id: String, val name: String): Entity5()
    data class Medium(val id: String, val name: String): Entity5()
    data class Hard(val id: String, val name: String, val multiplier: Float): Entity5()
}

// Extension method
fun Entity5.Medium.printInfo() {
    println("medium class $id")
}

// extension property
val Entity5.Medium.info: String
    get() = "some info"             //but needs custom backer

fun main() {

    val entity1 = Entity5.Easy("id","name")
    val entity2 = Entity5Factory.create(Entity5Type.MEDIUM)

    Entity5.Medium("id", "name").printInfo()

    // smart cast
    if (entity2 is Entity5.Medium) {
        entity2.printInfo()
        entity2.info
    }

}