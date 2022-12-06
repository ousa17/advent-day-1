package day6

import readInput


fun main() {
    val input = readInput("day6/Day06")

    part1(input)
    part2(input)
}

private fun part1(input: List<String>) {
    findStartOfPacket(input, 4)
}

private fun part2(input: List<String>) {
    findStartOfPacket(input, 14)
}

fun findStartOfPacket(input: List<String>, messageLength: Int) {
    val listOfFour = input.flatMap { it.toList() }.windowed(messageLength)
    val index = listOfFour.indexOfFirst { it.toSet().size == messageLength }
    println(index + messageLength)
}




