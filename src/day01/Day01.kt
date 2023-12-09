package day01

import println
import readInput

fun main() {
    fun part1(input: List<String>) = input.sumOf { line ->
        line.toCharArray()
            .filter { it.isDigit() }
            .let { "${it.first()}${it.last()}" }
            .toInt()
    }

    val digitStringsMap = mapOf(
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4,
        "five" to 5,
        "six" to 6,
        "seven" to 7,
        "eight" to 8,
        "nine" to 9,
    ) + "123456789".chunked(1).associateWith { it.toInt() }

    fun part2(input: List<String>) = input.sumOf {
        val first = it.findAnyOf(digitStringsMap.keys)?.second.orEmpty()
        val second = it.findLastAnyOf(digitStringsMap.keys)?.second.orEmpty()
        digitStringsMap.getOrDefault(first, 0) * 10 + digitStringsMap.getOrDefault(second, 0)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day01/Day01_test")
    check(part1(testInput) == 142)

    val testInput2 = readInput("day01/Day01a_test")
    check(part2(testInput2) == 281)

    val input = readInput("day01/Day01")
    part1(input).println()
    part2(input).println()
}
