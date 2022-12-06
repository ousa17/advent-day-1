package day3

import readInput


fun main() {
    val input = readInput("day3/Day03")

    part1(input)
    part2(input)

}

private fun part2(input: List<String>) {
    val badges = input.windowed(3, step = 3).map { findBadge(it) }
    val mapMyList = getMapCharPriority()
    val sumPriority =
        badges.map { input -> mapMyList.filter { it.key == input.first() }.values.first() }.sum()
    println(sumPriority)
}

fun findBadge(list: List<String>): String {
    val item1 = list.get(0)
    val item2 = list.get(1)
    val item3 = list.get(2)

    return item1.filter { item2.contains(it) && item3.contains(it) }
}

private fun part1(input: List<String>) {
    val mapMyList = getMapCharPriority()

    val mapSplitted =
        input.map { Pair(it.substring(0, it.length / 2), it.substring(it.length / 2, it.length)) }

    val listWrong = mapSplitted.map { twoString ->
        twoString.first.filter { twoString.second.contains(it) }
    }

    val sumPriority =
        listWrong.map { input -> mapMyList.filter { it.key == input.first() }.values.first() }.sum()

    println(sumPriority)
}


private fun getMapCharPriority(): Map<Char, Int> {
    val alphabetMajuscule = ('A'..'Z').toMutableList()
    val alphabetMinuscule = ('a'..'z').toMutableList()

    var map: Map<Char, Int> = emptyMap()
    for (i in 1..26) {
        map = map.plus(alphabetMinuscule[i - 1] to i)
    }
    for (i in 27..52) {
        map = map.plus(alphabetMajuscule[i - 27] to i)
    }
    return map
}
