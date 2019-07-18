package aquarium

fun main(args: Array<String>) {

    // List examples ...
    val testList = listOf(0,1,2,3,4,5,6,7)

    println(reverseList(testList))

    val tempList = listOf("a", 2, "dfsd")

    println(tempList.sumBy {
        if(it is Int) {
            it
        } else if (it is String) {
            it.length
        } else {
            0
        }
    })

    // Map examples ...
    val cures = mapOf<String, String>("india" to "delhi", "nepal" to "sdfsd")

    cures.getOrDefault("indo", "tintin")

    cures.getOrElse("indo") {"No cure for this"}

    val inventory = mutableMapOf<String, Int>("fish net" to 1)

    // Exercise ...
    bookCare()

}

fun bookCare() {
    val allBooks = setOf("Macbeth", "Romeo and Juliet", "Hamlet", "A Midsummer Night's Dream")
    val library = mapOf("Shakespeare" to allBooks)

    println(library.any { it.value.contains("Hamlet") })

    val moreBooks = mutableMapOf<String, String>("Wilhelm Tell" to "Schiller")
    moreBooks.getOrPut("Jungle Book") { "Kipling" }
    moreBooks.getOrPut("Hamlet") { "Shakespeare" }
    println(moreBooks.getOrPut("Wilhelm Tell"){ "Demo 1"})
    println(moreBooks)


    // PLaying with some constants ...
}

fun reverseList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for(i in list.size - 1 downTo 0) {
        result.add(list.get(i))
    }

    return result
}