package aquarium

// Value determined at compile time ..
const val rocks = 3

// Value determined at run time ..
val number = 5

const val num = 5

fun complexFuntionCall(){}

val result = complexFuntionCall()

// Cannot be done
// const val result1 = complexFuntionCall()

const val CONSTANT = "top-level constant"


// This is initialised lazily on the first access to this object ..
object Constants {
    const val CONSTANT2 = "object constant"
}

class MyClass {

    // This is initialised with the static onstructor of the class ..
    companion object {
        const val CONSTANT3 = "constant inside companion"
    }

    // const val CONSTANT4 = "class level constants cannot be defined"
}
