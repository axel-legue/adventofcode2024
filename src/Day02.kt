import kotlin.math.abs
import kotlin.math.absoluteValue

fun main() {
    fun part1(input: List<String>): Int {
        val thresholdValue = 3
        var validReportCount = 0
        val reports: List<List<String>> = input.map { value ->
            value.split(" ")
        }

        reports.forEach { report ->
            var isValid = true
            var initialSignIsPositive = true
            var currentSignIsPositive: Boolean

            for ((index, level) in report.withIndex()) {
                if (index == 0) continue
                val previousLevel = report[index - 1].toInt()
                val currentLevel = level.toInt()
               val diffLevel = currentLevel - previousLevel
                if(index == 1) {
                    initialSignIsPositive = diffLevel >= 0
                    currentSignIsPositive = initialSignIsPositive
                }else{
                    currentSignIsPositive = diffLevel >= 0
                }

                if (abs(diffLevel) > thresholdValue || diffLevel == 0 || initialSignIsPositive != currentSignIsPositive  ) {
                    isValid = false
                    break
                }
            }
            if (isValid) validReportCount++
        }

        return validReportCount
    }

    fun part2(input: List<String>): Int {
        return 1
    }

    val input = readInput("Day02")
    part1(input).println()
  //  part2(input).println()
}
