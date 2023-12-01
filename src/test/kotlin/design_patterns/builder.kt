package design_patterns

import org.testng.Assert.assertEquals
import org.testng.annotations.Test

class Component private constructor(builder: Builder) {
    var param1 : String? = null
    var param2 : Int? = null
    var param3 : Boolean? = null

    init {
        param1 = builder.param1
        param2 = builder.param2
        param3 = builder.getParam3()                                   // it is private field in Builder so need to use get method
    }

    class Builder {
        var param1 : String? = null
        var param2 : Int? = null
        private var param3 : Boolean? = null                           // example of a private field for builder will need getter

        fun setParam1(param1: String) = apply { this.param1 = param1 }
        fun setParam2(param2: Int) = apply { this.param2 = param2 }
        fun setParam3(param3: Boolean) = apply { this.param3 = param3 }
        fun build() = Component(this)

        fun getParam3() = param3
    }
}

class ComponentTest {
    @Test
    fun testBuilder_setAllParams() {
        val component = Component.Builder()                 // Component has private constructor so can only instantiate using Builder
            .setParam1("param1")
            .setParam2(2)
            .setParam3(true)
            .build()

        assertEquals("param1", component.param1)
        assertEquals(2, component.param2)
        assertEquals(true, component.param3)
    }

    @Test
    fun testBuilder_set2Params() {
        val component = Component.Builder()                 // Component has private constructor so can only instantiate using Builder
            .setParam1("param1")
            .setParam2(2)
            .build()

        assertEquals("param1", component.param1)
        assertEquals(2, component.param2)
        assertEquals(null, component.param3)
    }
}