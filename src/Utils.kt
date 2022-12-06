import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src", "$name.txt")
    .readLines()

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')


fun List<Map<Int, List<String>>>.addRangeToList(
    input: List<String>,
    leftIndex: Int,
    previousIndex: Int
): List<Map<Int, List<String>>> {
    val list = input.subList(leftIndex, previousIndex)
    val map = mapOf(list.sumOf { it.toInt() } to list)
    return this.plus(map)
}

fun convertStringToWinScore(text: String): Int {
    return when (text) {
        "A Z" -> (6 + 2)
        "B Z" -> (6 + 3)
        "C Z" -> (6 + 1)

        "A X" -> (0 + 3)
        "B X" -> (0 + 1)
        "C X" -> (0 + 2)


        "A Y" -> (3 + 1)
        "B Y" -> (3 + 2)
        "C Y" -> (3 + 3)


        else -> 0
    }
}

fun convertStringToScore(text: String): Int {
    return when (text) {
        "A X" -> 4  //ok
        "B Y" -> 5  //ok
        "C Z" -> 6  //OK

        "A Y" -> 8  //OK
        "B Z" -> 9
        "C X" -> 7

        "A Z" -> 3
        "B X" -> 1  //OK
        "C Y" -> 2


        else -> 0
    }
}