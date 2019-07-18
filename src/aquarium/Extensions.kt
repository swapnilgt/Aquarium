package aquarium

// Extension functions are utils functions that we might want to define. These have to be defined outside the classes
// So, we do not change the code inside the class and hence protecting it's behavior.

fun String.hasSpaces(): Boolean {
     val found:Char? = this.find { it == ' ' }
    return found != null
}

fun extensionsExample() {
    "Does it have spaces?".hasSpaces()
}

open class AquariumPlan(val color: String, private val size: Int)
class GreenLeafyPlant(size: Int): AquariumPlan("Green", size)

fun AquariumPlan.print() = println("AquariumPlant")
fun GreenLeafyPlant.print() = println("GreenLeafyPlant")

fun staticExample() {
    val plant = GreenLeafyPlant(size = 50)
    plant.print() // GreenLeafyPlant

    // The below is printed because the value is assigned statically during the compile time
    val aquariumPlan: AquariumPlan = plant
    aquariumPlan.print() // AquariumPlan
}


// Extending the properties ...
val AquariumPlan.isGreen: Boolean
    get() = color == "Green"

fun propertyExample() {
    val plant = AquariumPlan("Green", 50)
    plant.isGreen // true
}

fun AquariumPlan?.pull() {
    // This runs the code block inside apply... if the current object is not null
    this?.apply {
        println("removing $this")
    }
}

fun bullableExample() {
    val plant: AquariumPlan? = null
    plant.pull() // ok
}