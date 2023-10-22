package Baekjoon.Baekjoon_11403

import java.util.LinkedList
import java.util.Queue

val size = readln().toInt()
val data = Array(size){ BooleanArray(size) }
fun main() {
    val sb = StringBuilder()

    for (i in 0..<size) {
        val split = readln().split(" ")
        for (j in 0..<size) {
            val selectData = split[j].toInt()
            if (selectData == 0) {
                data[i][j] = false
            } else {
                data[i][j] = true
            }
        }
    }

    for (i in 0..<size) {
        sb.append(toString(solve(i))).append("\n")
    }
    print(sb)
}

fun solve(start:Int): BooleanArray {
    val queue: Queue<Int> = LinkedList()
    val isVisit = BooleanArray(size)

    for (i in 0..<size) {
        if (data[start][i]) {
            queue.add(i)
            isVisit[i] = true
        }
    }

    while (queue.isNotEmpty()) {
        val visit = queue.remove()
        for (i in 0..<size) {
            if (data[visit][i] && !isVisit[i]) {
                queue.add(i)
                isVisit[i] = true
            }
        }
    }
    return isVisit
}

fun toString(data: BooleanArray): String {
    val sb = StringBuilder()
    for (i in 0..<size) {
        if (data[i]) {
            sb.append("1 ")
        } else {
            sb.append("0 ")
        }
    }
    return sb.toString()
}
