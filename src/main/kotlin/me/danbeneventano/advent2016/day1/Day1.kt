package me.danbeneventano.advent2016.day1

import java.util.*

fun main(args: Array<String>) {
    val input = "R1, R1, R3, R1, R1, L2, R5, L2, R5, R1, R4, L2, R3, L3, R4, L5, R4, R4, R1, L5, L4, R5, R3, L1, R4, R3, L2, L1, R3, L4, R3, L2, R5, R190, R3, R5, L5, L1, R54, L3, L4, L1, R4, R1, R3, L1, L1, R2, L2, R2, R5, L3, R4, R76, L3, R4, R191, R5, R5, L5, L4, L5, L3, R1, R3, R2, L2, L2, L4, L5, L4, R5, R4, R4, R2, R3, R4, L3, L2, R5, R3, L2, L1, R2, L3, R2, L1, L1, R1, L3, R5, L5, L1, L2, R5, R3, L3, R3, R5, R2, R5, R5, L5, L5, R2, L3, L5, L2, L1, R2, R2, L2, R2, L3, L2, R3, L5, R4, L4, L5, R3, L4, R1, R3, R2, R4, L2, L3, R2, L5, R5, R4, L2, R4, L1, L3, L1, L3, R1, R2, R1, L5, R5, R3, L3, L3, L2, R4, R2, L5, L1, L1, L5, L4, L1, L1, R1"

    var x = 0
    var y = 0

    var dir = 0 // 0 up, 1 right, 2 down, 3 left

    val array = ArrayList<Pair<Int,Int>>()

    var found = false
    var firstMeeting = 0

    input.split(", ").forEach {
        val dirLetter = it.substring(0, 1)
        val amount = Integer.parseInt(it.substring(1))
        when(dirLetter) {
            "L" -> dir = (dir - 1 + 4) % 4
            "R" -> dir = (dir + 1 + 4) % 4
        }
        for(i in 1..amount){
            when(dir) {
                0 -> y += 1
                1 -> x += 1
                2 -> y -= 1
                3 -> x -= 1
            }
            if(!found){
                for(pair in array){
                    if(pair.first == x && pair.second == y){
                        found = true
                        firstMeeting = Math.abs(x) + Math.abs(y)
                        break
                    }
                }
                array.add(Pair(x, y))
            }
        }
    }
    val total = Math.abs(x) + Math.abs(y)
    println(total)
    println(firstMeeting)
}