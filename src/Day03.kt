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
        val regex = Regex("mul\\((\\d{1,3}),(\\d{1,3})\\)|do\\(\\)|don't\\(\\)")
        var total: Int = 0
        var shouldDoTheMultiplication = true
        input.forEach {
            regex.findAll(it).forEach { matchResult ->
                when {
                    matchResult.value.startsWith("mul") -> {
                        val (firstNumber, secondNumber) = matchResult.groups[1]?.value?.toInt() to matchResult.groups[2]?.value?.toInt()
                        if (firstNumber != null && secondNumber != null && shouldDoTheMultiplication) total += (firstNumber * secondNumber)
                    }
                    matchResult.value == "do()" -> shouldDoTheMultiplication = true
                    matchResult.value == "don't()" -> shouldDoTheMultiplication = false
                }
            }
        }

        return total
    }

    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}
