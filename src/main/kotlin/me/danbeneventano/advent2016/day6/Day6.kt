package me.danbeneventano.advent2016.day6

import me.danbeneventano.advent2016.Common.getFile
import java.io.File

fun main(args: Array<String>) {
    val input = getFile(6)
    var answer = ""
    var answer2 = ""
    for(i in 0..7) {
        var column = ""
        input.readLines().forEach { line ->
            column += line[i]
        }
        val map = column.groupBy { it }.mapValues { it.value.count() }.toSortedMap()
        answer += map.keys.sortedByDescending { map[it] }[0]
        answer2 += map.keys.sortedBy { map[it] }[0]
    }
    println(answer)
    println(answer2)
}