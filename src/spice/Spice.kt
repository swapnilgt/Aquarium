package spice

fun main(args: Array<String>) {

    val spice: Curry = Curry("curry", "mild")

    println("The name is ${spice.name} and the heat is ${spice.heat}")
    spice.prepareSpice()
    spice.grind()

}

abstract class Spice(val name: String, val spiciness: String = "mild") {

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

class Curry(name: String, spiciness: String): Spice(name, spiciness), Grinder {

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

//fun makeSalt() = Spice("salt", "")