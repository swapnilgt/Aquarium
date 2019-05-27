fun main(args: Array<String>) {

    print("Enter your mood: ")

    println(whatShouldIDoToday(readLine()!!))
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