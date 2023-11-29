package T04_classes.Companion_objects

import java.util.*

// DATA CLASSES have their own generated hash codes so if they are different values they will not be equal ofc
enum class Entity4Type {
    HELP, EASY, MEDIUM, HARD;

    fun geFormattedName() = name.lowercase()
        .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
}


object Entity4Factory {
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

sealed class Entity4 () {
    object Help : Entity5(){            // companion object need to extend from parent Entity3
        val name = "Help"
    }

    // We can overwrite equals or hascodes by adding functions to the class itself
    data class Easy(val id: String, val name: String): Entity5() {
        override fun equals(other: Any?): Boolean {
           return super.equals(other)
        }

        override fun hashCode(): Int {
            return super.hashCode()
        }
    }
    data class Medium(val id: String, val name: String): Entity5()
    data class Hard(val id: String, val name: String, val multiplier: Float): Entity5()

}

fun main() {
    // these will not be equal because they are different , they create UUID each its own
    // val entity1 = Entity4Factory.create(Entity4Type.EASY)
    // val entity2 = Entity4Factory.create(Entity4Type.EASY)

    // these are equal because they have same data
    // val entity1 = Entity4.Easy("id","name")
    // val entity2 = Entity4.Easy("id","name")

    // data classes can copy constructors
    val entity1 = Entity5.Easy("id","name")
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