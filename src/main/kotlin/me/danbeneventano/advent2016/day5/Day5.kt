package me.danbeneventano.advent2016.day5

import org.apache.commons.codec.binary.Hex
import java.nio.charset.Charset
import java.security.MessageDigest
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    var index = 0
    var pw = ""
    val pw2 = "xxxxxxxx".toCharArray()
    val digest = MessageDigest.getInstance("MD5")
    val time = measureTimeMillis {
        while (pw.length < 8 || pw2.contains('x')) {
            val input = ("wtnhxymk" + index).toByteArray(Charset.forName("UTF-8"))
            digest.update(input)
            val result = digest.digest()
            val hex = Hex.encodeHexString(result)
            if (hex.startsWith("00000")) {
                if (pw.length < 8) pw += hex[5]
                if(pw2.contains('x')) {
                    if(Character.isDigit(hex[5])){
                        val pos = Integer.parseInt(hex[5] + "")
                        if(pos < 8){
                            if (pw2[pos] == 'x') {
                                pw2.set(pos, hex[6])
                            }
                        }
                    }
                }
            }
            index++
        }
    }
    println(pw) // part 1
    println(pw2.joinToString("")) // part 2
    println("$time ms")
}