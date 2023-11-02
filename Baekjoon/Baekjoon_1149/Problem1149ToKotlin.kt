package Baekjoon.Baekjoon_1149

import kotlin.math.min

fun main() {
    val houseCount = readln().toInt()
    val data = Array(houseCount) { IntArray(3) }
    var minValue = Int.MAX_VALUE

    for (i in 0..<houseCount) {
        val splitData = readln().split(" ").map { s -> s.toInt() }.toList()
        data[i][0] = splitData[0]
        data[i][1] = splitData[1]
        data[i][2] = splitData[2]
    }

    for (i in 1..<houseCount) {
        data[i][0] += min(data[i - 1][1], data[i - 1][2]);
        data[i][1] += min(data[i - 1][0], data[i - 1][2]);
        data[i][2] += min(data[i - 1][0], data[i - 1][1]);
    }

    for (i in 0..<3) {
        minValue = min(data[houseCount - 1][i], minValue)
    }

    print(minValue)
}