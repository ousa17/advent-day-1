package day4

import readInput


fun main() {
    val input = readInput("day4/Day04")

    part1(input)
    part2(input)

}

private fun part1(input: List<String>) {
    val sum = input.map {
        it.split(",").let { (firstElfRange, secondElfRange) ->
            firstElfRange.toRange() to secondElfRange.toRange()
        }
    }.count { pair ->
        val secondInFirst = pair.first.map { pair.second.contains(it) }.reduce { acc, b ->
            acc && b
        }
        val firstInSecond = pair.second.map { pair.first.contains(it) }.reduce { acc, b ->
            acc && b
        }
        secondInFirst || firstInSecond
    }
    println(sum)
}

private fun part2(input: List<String>) {
    val sum = input.map { it.split(",").let { (firstElfRange, secondElfRange) ->
        firstElfRange.toRange() to secondElfRange.toRange()
    }
    }.count { pair ->
        (pair.first intersect pair.second).isNotEmpty()
    }
    println(sum)
}

fun String.toRange() = this.split("-").let { (a, b) -> a.toInt()..b.toInt() }

