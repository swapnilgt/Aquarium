package book

import kotlin.random.Random

const val MAX_BOOK_BORROWED = 10

object Constants {
    const val BASE_URL = "http://www.books.com"
}

open class Book(val title: String, val author: String, var pages: Int) {

    companion object {
        const val BASE_URL = "http://www.books.com"
    }

    private var currentPage: Int = 0

    fun getBasicDesc(): Pair<String, String> {
        return title to author
    }

    fun getDesc(): Triple<String, String, Int> {
        return Triple(title, author, 1989)
    }

    open fun readPage() {
        this.currentPage++
        println("Incrementing the page number to ${currentPage}")
    }

    fun canBorrow(booksBorrowed: Int): Boolean {
        return booksBorrowed < MAX_BOOK_BORROWED
    }

    fun printUrl() {
        println(Constants.BASE_URL + "/" + title + ".html")
    }
}

fun Book.getWeight(): Double {
    return pages * 1.5
}

fun Book.tornPages(torn: Int) {
    if (pages >= torn) pages -= torn else pages = 0
}

class eBook(title: String, author: String, pages: Int, val format: String = "text"): Book(title, author, pages) {

    private var wordCount: Int = 0

    override fun readPage() {
        this.wordCount = this.wordCount + 250
        println("Incrementing the word count to ${wordCount}")
    }
}

fun main(args: Array<String>) {

    val myBook = Book("Yellow", "Unknown", 250)
    println("The book can be borrowed ${myBook.canBorrow(15)}")
    myBook.printUrl()

    val puppy = Puppy()

    while (myBook.pages > 0) {
        puppy.playWithBook(myBook)
        println("${myBook.pages} left in ${myBook.title}")
    }
}

class Puppy {
    fun playWithBook(book: Book) {
        book.tornPages(Random(0).nextInt(12))
    }
}