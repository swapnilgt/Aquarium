fun main2(args: Array<String>) {
    //println("Good ${ if (args[0].toInt() < 12) "morning" else "night"}, Kotlin! ")
    //feedTheFish()
    print("Enter your birthday: ")
    val birthday = getBirthday()

    println(getRandomCookie(birthday))
}

fun getRandomCookie(birthday: Int): String {

    val msges = arrayOf("You will have a great day!",
            "Things will go well for you today.",
            "Enjoy a wonderful day of success.",
            "Be humble and all will turn out well.",
            "Today is a good day for exercising restraint.",
            "Take it easy and enjoy life!",
            "Treasure your friends because they are your greatest fortune.")

    println("The birthday is $birthday")

    return when(birthday) {
        28, 31 -> "This is the first one"
        in 1..7 -> "This is in the first week"
        else -> msges[birthday.rem(msges.size)]
    }
}

fun getBirthday(): Int {
    return readLine()?.toIntOrNull() ?: 1
}