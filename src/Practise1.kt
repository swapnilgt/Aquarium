import java.lang.Math.random
import java.util.*

fun main3(args: Array<String>) {

    print("Enter your mood: ")

    //println(whatShouldIDoToday(readLine()!!))

    val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper" )

    val sortedSpices = spices.filter { it.contains("curry") }.sortedBy { it.length }

    val startEnd = spices.filter { it.startsWith('c') and it.endsWith('e')}

    val firstThreeFilter = spices.take(3).filter { it.startsWith('c') }

    /*println("Step 1: $sortedSpices")*/
    /*println("Step 2: $startEnd")*/
    /*println("Step 3: $firstThreeFilter")*/

    //dirtyProcessor()

    gamePlay(rollDice(0))

    
}

fun whatShouldIDoToday(mood: String, weather: String = "sunny", temperature: Int = 24): String {
    return when {
        isHappyAndSunny(mood, weather) -> "go for a walk"
        isSadAndRainyAnd0(mood, weather, temperature) -> "stay in bed"
        isHot(temperature) -> "go swimming"
        else -> "Stay home and read."
    }
}

fun isHappyAndSunny(mood: String, weather: String) = mood == "happy" && weather == "Sunny"

fun isSadAndRainyAnd0(mood: String, weather: String, temperature: Int) = mood == "sad" && weather == "rainy" && temperature == 0

fun isHot(temperature: Int) = temperature > 35

var dirty = 20

val waterFilter: (Int) -> Int = {dirty -> dirty / 2}
fun feedFish(dirty: Int) = dirty + 10


fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

fun dirtyProcessor() {
    dirty = updateDirty(dirty, waterFilter)
    dirty = updateDirty(dirty, ::feedFish)
    dirty = updateDirty(dirty) {dirty ->
        dirty + 50
    }
}


fun gamePlay(roll: Int) {
    println("The roll of the dice is: $roll")
}

val rollDice: (Int) -> Int = { numSides -> when(numSides) {
  0 -> 0
  else -> Random().nextInt(12) + 1
}
}
