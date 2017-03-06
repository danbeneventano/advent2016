package me.danbeneventano.advent2016.day2

import me.danbeneventano.advent2016.Common.getFile
import java.io.File

fun main(args: Array<String>) {
    val input = getFile(2)
    var number = 5
    var answer = ""
    for(string in input.readLines()){
        for(char in string.toCharArray()) {
            when(char) {
                'U' -> if(number > 3) number -= 3
                'D' -> if(number < 7) number += 3
                'L' -> if(number != 1 && number != 4 && number != 7) number -= 1
                'R' -> if(number != 3 && number != 6 && number != 9) number += 1
            }
        }
        answer += number
    }
    println(answer) //part 1

    var num: Any? = 5
    var ans = ""

    val mapUp = mapOf(3 to 1, 6 to 2, 7 to 3, 8 to 4, "A" to 6, "B" to 7, "C" to 8, "D" to "B")
    val mapDown = mapOf(1 to 3, 2 to 6, 3 to 7, 4 to 8, 6 to "A", 7 to "B", 8 to "C", "B" to "D")
    val mapLeft = mapOf(4 to 3, 3 to 2, 9 to 8, 8 to 7, 7 to 6, 6 to 5, "C" to "B", "B" to "A")
    val mapRight = mapOf(2 to 3, 3 to 4, 5 to 6, 6 to 7, 7 to 8, 8 to 9, "A" to "B", "B" to "C")

    for(string in input.readLines()){
        for(char in string.toCharArray()){
            when(char) {
                'U' -> if(mapUp.containsKey(num)) num = mapUp[num]
                'D' -> if(mapDown.containsKey(num)) num = mapDown[num]
                'L' -> if(mapLeft.containsKey(num)) num = mapLeft[num]
                'R' -> if(mapRight.containsKey(num)) num = mapRight[num]
            }
        }
        ans += num
    }

    println(ans) //part 2

}