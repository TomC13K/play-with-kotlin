package T04_classes.Companion_objects

import java.util.*

enum class Entity3Type {
    HELP, EASY, MEDIUM, HARD;

    fun geFormattedName() = name.lowercase()
        .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
}


object Entity3Factory {
    fun create( type: Entity5Type) : Entity3 {
        val id = UUID.randomUUID().toString()
        val name = when(type) {
            Entity5Type.HELP -> type.name
            Entity5Type.EASY -> type.name
            Entity5Type.MEDIUM -> type.geFormattedName()
            Entity5Type.HARD -> "Hard"
        }
        return when(type) {
            Entity5Type.HELP -> Entity3.Help
            Entity5Type.EASY -> Entity3.Easy(id, name)
            Entity5Type.MEDIUM -> Entity3.Medium(id, name)
            Entity5Type.HARD -> Entity3.Hard(id, name, 2.0f)
        }
    }
}

// sealled classes can have dofferent properties and types
// smart cast will take care of them
sealed class Entity3 () {
    object Help : Entity3(){            // companion object need to extend from parent Entity3
        val name = "Help"
    }
    data class Easy(val id: String, val name: String): Entity3()
    data class Medium(val id: String, val name: String): Entity3()
    data class Hard(val id: String, val name: String, val multiplier: Float): Entity3()

}

fun main() {
    val entity = Entity3Factory.create(Entity5Type.EASY)    //get EASY class.. or HELP class. ....
    println(entity)

val msg = when(entity) {
    Entity3.Help -> "help class"              // singleton object declaration
    is Entity3.Easy -> "easy class"
    is Entity3.Medium -> "medium class"
    is Entity3.Hard -> "hard class"
}
    println(msg)
}