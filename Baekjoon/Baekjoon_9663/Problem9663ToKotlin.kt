package Baekjoon.Baekjoon_9663

import kotlin.math.abs

val chessSize = readln().toInt()
val chessTable = IntArray(chessSize)
var count = 0

fun main() {
    for (i in 0..< chessSize) {
        chessTable[0] = i
        dfs(1)
    }
    print(count)
}

fun dfs(x: Int) {
    if (x == chessSize) {
        count++
        return
    }

    for (i in 0..<chessSize) {
        if (isPossible(x, i)) {
            chessTable[x] = i
            dfs(x + 1)
        }
    }
}

fun isPossible(x: Int, visit: Int): Boolean {

    for (i in 0..<x) {
        if (chessTable[i] == visit || abs(i - x) == abs(chessTable[i] - visit)) {
            return false
        }
    }
    return true
}
