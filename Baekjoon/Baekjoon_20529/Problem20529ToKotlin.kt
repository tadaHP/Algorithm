package Baekjoon.Baekjoon_20529

import kotlin.math.min

var minValue: Int = 0

fun main() {
    val sb = StringBuilder()
    val size = readln().toInt()
    for (i in 0..<size) {
        val caseSize = readln().toInt()
        val data = readln().split(" ")
        if (caseSize > 32) {
            sb.append("0\n")
        } else {
            solve(caseSize, data)
            sb.append(minValue).append("\n")
        }
    }
    println(sb)
}

fun solve(caseSize:Int, data: List<String>) {
    var count = 0
    minValue = Int.MAX_VALUE
    for (i in 0..<caseSize - 2) {
        val select1 = data[i]
        for (j in i + 1..<caseSize - 1) {
            val select2 = data[j]
            for (k in j + 1..<caseSize) {
                val select3 = data[k]

                for (l in 0..<4) {
                    if (select1[l] != select2[l]) {
                        count++;
                    }
                    if (select1[l] != select3[l]) {
                        count++;
                    }
                    if (select2[l] != select3[l]) {
                        count++;
                    }
                }
                minValue = min(minValue, count)
                count = 0
            }
        }
    }

}