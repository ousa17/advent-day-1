package day5


import readInput


val list1 = mutableListOf("S", "L", "W")
val list2 = mutableListOf("J", "T", "N", "Q")
val list3 = mutableListOf("S", "C", "H", "F", "J")
val list4 = mutableListOf("T", "R", "M", "W", "N", "G", "B")
val list5 = mutableListOf("T", "R", "L", "S", "D", "H", "Q", "B")
val list6 = mutableListOf("M", "J", "B", "V", "F", "H", "R", "L")
val list7 = mutableListOf("D", "W", "R", "N", "J", "M")
val list8 = mutableListOf("B", "Z", "T", "F", "H", "N", "D", "J")
val list9 = mutableListOf("H", "L", "Q", "N", "B", "F", "T")
val listAll = mutableListOf(list1, list2, list3, list4, list5, list6, list7, list8, list9)

fun main() {
    val input = readInput("day5/Day05")

    part1(input)
    part2(input)

}

private fun part1(input: List<String>) {
    input.map {
        val regex = """move (\d+) from (\d+) to (\d+)""".toRegex()
        val matchResult = regex.find(it)
        val (numberOfCrate, fromStack, toStack) = matchResult!!.destructured
        val fromIndex = fromStack.toInt() - 1
        val toIndex = toStack.toInt() - 1

        repeat(numberOfCrate.toInt()) {
            val lastItem = listAll[fromIndex].last()
            listAll[toIndex].apply {
                add(lastItem)
            }
            listAll[fromIndex].apply {
                //remove(last()) wrong
                //remove(lastItem) wrong
                removeAt(this.size-1)
            }
        }
    }
    listAll.map {
        print(it.last())
    }
}

private fun part2(input: List<String>) {

    input.map {
        val regex = """move (\d+) from (\d+) to (\d+)""".toRegex()
        val matchResult = regex.find(it)
        val (numberOfCrate, fromStack, toStack) = matchResult!!.destructured
        val fromIndex = fromStack.toInt() - 1
        val toIndex = toStack.toInt() - 1
        val listToMove = listAll[fromIndex].let {
            it.subList(it.size - numberOfCrate.toInt(), it.size)
        }
        listAll[toIndex].apply {
            addAll(listToMove)
        }
        listAll[fromIndex] = listAll[fromIndex].run {
            this.subList(0, this.size - numberOfCrate.toInt())
        }
    }

    listAll.map {
        print(it.last())
    }
}
