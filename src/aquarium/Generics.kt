package aquarium

class MyIntList {
    fun get(pos: Int): Int {return 0}
    fun addItem(item: Int) {}
}

class MyList<T> {
    fun get(pos: Int): T {
        TODO("implement")
    }
    fun addItem(item: T) {}
}

fun workWithMyList() {
    val intList: MyList<String>
}