import kotlin.math.abs
import kotlin.math.absoluteValue

fun main() {
    fun part1(input: List<String>): Int {
        val locations = input.map { value ->
            value.split("   ")
        }
        val locationsA = locations.map { it[0].toInt() }.sorted()
        val locationsB = locations.map { it[1].toInt() }.sorted()

        return locationsA.zip(locationsB) { a, b ->
            abs(a - b)
        }.sum()
    }

    fun part2(input: List<String>): Int {
        val locations = input.map { value ->
            value.split("   ")
        }
        val locationsA = locations.map { it[0].toInt() }
        val locationsB = locations.map { it[1].toInt() }
        val commonElements =
            locationsA.filter { it in locationsB } + locationsB.filter { it in locationsA }

        val similarity = commonElements.groupingBy { it }
            .eachCount()
            .map { (key, count) -> key * (count - 1) }
            .sum()

        return similarity
    }

    // Test if implementation meets criteria from the description, like:
    // check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    //  val testInput = readInput("Day01_test")
    //   check(part1(testInput) == 1)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
