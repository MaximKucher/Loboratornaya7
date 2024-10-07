fun isPalindrome(word: String): Boolean {
    val cleanedWord = word.replace("\\s".toRegex(), "").lowercase()
    return cleanedWord == cleanedWord.reversed()
}

fun main() {
    val word = "Котик"
    if (isPalindrome(word)) {
        println("$word — палиндром.")
    } else {
        println("$word — не палиндром.")
    }
}
