fun main() {
    val string = "To become a programmer, you need to write code. To write code, you have to learn. To learn, you need desire."
    val word = "code"
    val indexOfFirstWord = getIndexOfFirstWord(string, word)
    val indexOfLastWord = getIndexOfLastWord(string, word)
    println("The index of the first character of the first instance of the word \"$word\" is $indexOfFirstWord")
    println("The index of the first character of the last instance of the word \"$word\" is $indexOfLastWord")
}

fun getIndexOfFirstWord(string: String, word: String): Int {
    return string.indexOf(word)
}

fun getIndexOfLastWord(string: String, word: String): Int {
    return string.lastIndexOf(word)
}
