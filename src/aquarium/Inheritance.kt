package aquarium

fun main(args: Array<String>) {
    delegate()
}

fun delegate() {
    val pleco = Plecostomus1()
    println("Fish has color ${pleco.color}")
    pleco.eat()
}

interface FishAction1 {
    fun eat()
}

interface FishColor {
    var color: String

    fun changeColor(newColor: String) {
        color = newColor
    }
}

class Plecostomus1(fishColor: FishColor = GoldColor):
        FishAction1 by PrintingFishAction("a lot of algae"),
        FishColor by fishColor

object GoldColor: FishColor {
    override var color = "gold"
}

object RedColor: FishColor {
    override var color = "red"
}

class PrintingFishAction(val food: String): FishAction1 {

    override fun eat() {
        println("eat $food")
    }

}