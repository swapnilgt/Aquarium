package aquarium.declarations

fun main(args: Array<String>) {
    makeDecorations()
}

fun makeDecorations() {
    val d1 = Declarations("granite")
    println(d1)

    val d2 = Declarations("slate")
    println(d2)

    val d3 = Declarations("slate")
    println(d3)

    println(d1.equals(d2))
    println(d3.equals(d2))

    val d5 = Decorations2("crystal", "wood", "diver")
    val(rock, wood, diver) = d5



}

data class Declarations(val rocks: String)

data class Decorations2(val rocks: String, val wood: String, val driver: String)