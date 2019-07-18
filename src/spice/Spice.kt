package spice

import aquarium.Color
import spice.YellowSpiceColor.color
import spice.declarations.SpiceContainer

fun main(args: Array<String>) {

    /*val spice: Curry = Curry("curry", "mild")

    println("The name is ${spice.name} and the heat is ${spice.heat}")
    spice.prepareSpice()
    spice.grind()*/

    /*val spice: Curry = Curry("curry", "mild")
    println("The spice color is ${spice.color}")*/

    declarationExp()

}

abstract class Spice(val name: String, val spiciness: String = "mild", color: SpiceColor): SpiceColor by color {

    abstract fun prepareSpice()

    val heat: Int
        get() {
            return when(spiciness) {
                "mild" -> 1
                "medium" -> 3
                "spicy" -> 5
                "very spicy" -> 7
                "extremely spicy" -> 10
                else -> 0
            }
        }

    init {
        println("The spice name is ${this.name} and the spiciness level is ${this.heat}")
    }
}

class Curry(name: String, spiciness: String, color: SpiceColor = YellowSpiceColor): Spice(name, spiciness, color), Grinder {

    override fun prepareSpice() {
        println("We are preparing the curry")
    }

    override fun grind() {
        println("We are grinding the curry")
    }
}

interface Grinder {
    fun grind()
}

interface SpiceColor {
    var color: Color
}

object YellowSpiceColor: SpiceColor {
    override var color: Color = Color.YELLOW
}

fun declarationExp() {
    val spiceCabinet = listOf(SpiceContainer(Curry("Yellow Curry", "mild")),
            SpiceContainer(Curry("Red Curry", "medium")),
            SpiceContainer(Curry("Green Curry", "spicy")))

    for(element in spiceCabinet) println(element.label)
}

//fun makeSalt() = Spice("salt", "")