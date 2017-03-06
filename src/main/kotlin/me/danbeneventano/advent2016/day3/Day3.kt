package me.danbeneventano.advent2016.day3

import me.danbeneventano.advent2016.Common.getFile
import java.io.File
import java.util.*

fun main(args: Array<String>) {
    val input = getFile(3)

    val a = input.readLines()
            .map(String::trim)
            .map { it.replace("  *".toRegex(), " ") }
            .map { it.split(" ") }
            .map { it.map(String::toInt) }
    val answer1 = a
            .map { it.sorted() }
            .filter { it[0] + it[1] > it[2] }
            .count()
    println(answer1) // part 1

    var possible = 0

    val list = ArrayList<Int>()

    for(j in 0..2) {
        a.forEach { list.add(it[j]) }
    }

    for(i in 0..list.size-1 step 3){
        val l = listOf(list[i], list[i+1], list[i+2]).sorted()
        if(l[0] + l[1] > l[2]) possible++
    }

    println(possible) // part 2

}