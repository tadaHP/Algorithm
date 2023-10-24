package Baekjoon.Baekjoon_17626

import kotlin.math.min

fun main() {
    val number = readln().toInt()
    val data = IntArray(50000 + 1)

    data[1] = 1

    for (i in 2..number) {
        var min: Int = Int.MAX_VALUE
        var j = 1
        while (j * j <= i) {
            min = min(min, data[i - j * j])
            j++
        }
        data[i] = min + 1
    }
    print(data[number])
}