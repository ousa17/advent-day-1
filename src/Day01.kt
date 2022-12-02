fun main() {
    val input = readInput("Day01")

    val it: ListIterator<String> = input.listIterator()

    var mapTotalAndCalories: List<Map<Int, List<String>>> = emptyList()

    var leftIndex = 0
    while (it.hasNext()) {
        val item = it.next()
        if (item == "") {
            mapTotalAndCalories =
                mapTotalAndCalories.addRangeToList(input, leftIndex, it.previousIndex())
            leftIndex = it.nextIndex()
        } else if (it.previousIndex() + 1 == input.size) {
            mapTotalAndCalories =
                mapTotalAndCalories.addRangeToList(input, leftIndex, it.previousIndex() + 1)
        }
    }
    val solution1 = mapTotalAndCalories.maxOf { it.keys.maxOf { it } }
    val solution2 = mapTotalAndCalories.flatMap {
        it.keys
    }.sortedByDescending { it }.take(3).sum()

    println(solution1)
    println(solution2)


}
