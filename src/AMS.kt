import java.util.*

fun main1(args: Array<String>) {
    println("Good ${ if (args[0].toInt() < 12) "morning" else "night"}, Kotlin! ")
    feedTheFish()
    eagerExample()

    /*println(canAddFish(10.0, listOf(3,3,3)))
    println(canAddFish(8.0, listOf(2,2,2), hasDecorations = false))
    println(canAddFish(9.0, listOf(1,1,3), 3))
    println(canAddFish(10.0, listOf(), 7, true))*/
}

fun eagerExample() {
    val decoration = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

    // Eager behavior ... the filter creates a new instance of the list ...
    val eager = decoration.filter { it[0] == 'p' }
    println(eager)

    // Apply lazily ...
    val filtered = decoration.asSequence().filter { it[0] == 'p' }
    println(filtered.toList())

    // Apply map lazily ...
    val lazyMap = decoration.asSequence().map {
        println("map: $it")
        it
    }

    println(lazyMap)
    println("first: ${lazyMap.first() }")
    println("all: ${lazyMap.toList()}")
}

fun shouldChangeWater() = 20

fun shouldChangeWater(day: String, temp: Int = 22, dirty: Int = shouldChangeWater()): Boolean {
    return when {
        isTooHot(temp) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

fun isTooHot(temp: Int) = temp > 30

fun isDirty(dirty: Int) = dirty > 30

fun isSunday(day: String) = day == "Sunday"

fun canAddFish(tankSize: Double, fishSizes: List<Int>, newFishSize: Int = 2, hasDecorations: Boolean = true): Boolean {

    // Updating the tank size if needed ..
    var updatedTankSize = tankSize
    if(hasDecorations) {
        updatedTankSize = 0.8.times(tankSize)
    }


    return  updatedTankSize - (fishSizes.sum() + newFishSize) >= 0
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and this fish eat $food")

    if(shouldChangeWater(day, 35)) {
        println("We need to change the water today!")
    }
}

fun randomDay(): String {
    val week = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week.get(Random().nextInt(7))
}

fun fishFood(day: String) : String {

    return when(day) {
        "Monday" -> "Monday food"
        "Tuesday" -> "Tuesday food"
        "Wednesday" -> "Wednesday food"
        "Thursday" -> "Thursday food"
        "Friday" -> "Friday food"
        "Saturday" -> "Saturday food"
        "Sunday" -> "Sunday food"
        else -> "fasting"
    }
}