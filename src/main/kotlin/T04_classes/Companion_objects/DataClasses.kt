package T04_classes.Companion_objects

import java.util.*

// DATA CLASSES have their own generated hash codes so if they are different values they will not be equal ofc
enum class Entity4Type {
    HELP, EASY, MEDIUM, HARD;

    fun geFormattedName() = name.lowercase()
        .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
}


object Entity4Factory {
    fun create( type: Entity4Type) : Entity4 {
        val id = UUID.randomUUID().toString()
        val name = when(type) {
            Entity4Type.HELP -> type.name
            Entity4Type.EASY -> type.name
            Entity4Type.MEDIUM -> type.geFormattedName()
            Entity4Type.HARD -> "Hard"
        }
        return when(type) {
            Entity4Type.HELP -> Entity4.Help
            Entity4Type.EASY -> Entity4.Easy(id, name)
            Entity4Type.MEDIUM -> Entity4.Medium(id, name)
            Entity4Type.HARD -> Entity4.Hard(id, name, 2.0f)
        }
    }
}

sealed class Entity4 () {
    object Help : Entity4(){            // companion object need to extend from parent Entity3
        val name = "Help"
    }
    data class Easy(val id: String, val name: String): Entity4()
    data class Medium(val id: String, val name: String): Entity4()
    data class Hard(val id: String, val name: String, val multiplier: Float): Entity4()

}

fun main() {
    // these will not be equal because they are different , they create UUID each its own
    // val entity1 = Entity4Factory.create(Entity4Type.EASY)
    // val entity2 = Entity4Factory.create(Entity4Type.EASY)

    // these are equal because they have same data
    // val entity1 = Entity4.Easy("id","name")
    // val entity2 = Entity4.Easy("id","name")

    // data classes can copy constructors
    val entity1 = Entity4.Easy("id","name")
    // val entity2 = entity1.copy()                                      // equal
    val entity2 = entity1.copy(name = "myname")                         // NOT equal

    // this only compares data values itself
    if(entity1 == entity2) {
        println("they are equal")
    } else {
        println("they are not equal")
    }

    // this only compares data values and reference too    ===
    // beacuse they are 2 different instances they are NOT equal
    if(entity1 === entity2) {
        println("they are equal")
    } else {
        println("they are not equal")
    }

    if(entity1 === entity1) {          // enmtity1 is ofc equal to itself
        println("they are equal")
    } else {
        println("they are not equal")
    }

}