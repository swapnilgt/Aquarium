package aquarium5

data class Fish(var name: String)

fun main(args: Array<String>) {
    fishExamples()
}

fun fishExamples() {
    val fish = Fish("splashy")


    // 'with' is a higher order function ..
    // without inline an object is created every call to myWith
    myWith(fish.name) {
        println(capitalize())
    }

    // with inline no object is created, and lambda body is inlined here ...
    fish.name.capitalize()

    println(fish.run { name })

    println(fish.apply {})

    val fish2: Fish = Fish(name = "splashy").apply { name = "Sharky" }
    println(fish2.name)

    println(fish.let { it.name.capitalize() }
            .let { it + "fish" }
            .let { it.length }
            .let { it + 31 })

    // Exercise ..
    val numbers = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
    print(numbers.divisibleBy {
        it.rem(3)
    })
}

inline fun myWith(name: String, block: String.() -> Unit) {
    name.block()
}


fun List<Int>.divisibleBy(block: (Int) -> Int) : List<Int> {
    val result = mutableListOf<Int>()
    for (item in this) {
        if (block(item) == 0) {
            result.add(item)
        }
    }
    return result
}
