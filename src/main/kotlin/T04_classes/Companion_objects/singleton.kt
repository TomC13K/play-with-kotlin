package T04_classes.Companion_objects

import java.util.*

enum class Entity2Type {
    EASY, MEDIUM, HARD;

    fun geFormattedName() = name.lowercase()
        .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
}


object EntityFactory {
   // fun create() = Entity2("id", "naaaame")
   fun create( type: Entity2Type) : Entity2 {
       val id = UUID.randomUUID().toString()
       val name = when(type) {
           Entity2Type.EASY -> type.name                    // matches to what classname defines
           Entity2Type.MEDIUM -> type.geFormattedName()     // useing the formatted name
           Entity2Type.HARD -> "Hard"
       }
       return Entity2(id, name)
   }
}


class Entity2 (val id: String, val name: String) {
    override fun toString(): String {
        return "id: $id name: $name"
    }
}


fun main() {
    val entity = EntityFactory.create(Entity2Type.EASY)
    println(entity)

    val mediumEntity = EntityFactory.create(Entity2Type.MEDIUM)
    println(mediumEntity)
}