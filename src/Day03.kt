import kotlin.math.abs
import kotlin.math.absoluteValue

fun main() {
    fun part1(input: List<String>): Int {
        val regex = Regex("mul\\((\\d{1,3}),(\\d{1,3})\\)")
        var total: Int = 0
        input.forEach {
            regex.findAll(it).forEach { mathResult ->
                val firstNumber = mathResult.groups[1]?.value?.toInt()
                val secondNumber = mathResult.groups[2]?.value?.toInt()
                if (firstNumber != null && secondNumber != null) total += (firstNumber * secondNumber.toInt())
            }
        }
        return total
    }


    fun part2(input: List<String>): Int {
        return 1
    }

    val input = readInput("Day03")
    part1(input).println()
    //  part2(input).println()
}
