package me.danbeneventano.advent2016.day4

import me.danbeneventano.advent2016.Common.getFile
import java.io.File


fun main(args: Array<String>) {
    val input = getFile(4)
    var total = 0
    var northpole = 0
    input.readLines().forEach {
        val csum = it.split("[")[1].replace("]", "")
        val dashes = it.length - it.replace("-", "").length
        val sector = it.split("-")[dashes].substring(0, 3).toInt()
        var name = it.split("[")[0]
        name = name.substring(0, name.length-4).replace("-", "")
        val map = name.groupBy { it }.mapValues { it.value.count() }.toSortedMap()
        val ncsum = map.keys.sortedByDescending { map[it] }.take(5).joinToString("")
        if (ncsum == csum) total += sector
        val realname = name.map { (((it-'a'+sector)%26)+'a'.toInt()).toChar() }.joinToString("")
        if(realname == "northpoleobjectstorage") northpole = sector
    }
    println(total) // part 1
    println(northpole)
}