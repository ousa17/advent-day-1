package day2

import convertStringToScore
import convertStringToWinScore
import readInput

fun main() {
    val input = readInput("day2/Day02")
    val sum = input.map { convertStringToScore(it) }
    val total = sum.sum()
    println(total)
    val part2 = input.map { convertStringToWinScore(it) }
    val sum2 = part2.sum()
    println(sum2)
}
