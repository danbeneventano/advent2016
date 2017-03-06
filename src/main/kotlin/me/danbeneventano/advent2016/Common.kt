package me.danbeneventano.advent2016

import java.io.File

object Common {
    fun getFile(day: Int) = File(Thread.currentThread().contextClassLoader.getResource("day$day/input.txt").file)
}