package book

open class Book(val title: String, val author: String) {

    private var currentPage: Int = 0

    open fun readPage() = {
        this.currentPage++
        println("Incrementing the page number to ${currentPage}")
    }
}

class eBook(title: String, author: String, val format: String = "text"): Book(title, author) {

    private var wordCount: Int = 0

    override fun readPage() = {
        this.wordCount = this.wordCount + 250
        println("Incrementing the word count to ${wordCount}")
    }
}