package Baekjoon.Baekjoon_11279

import java.util.PriorityQueue

fun main() {
    val sb = StringBuilder()
    val priorityQueue = PriorityQueue<Int>(Comparator.reverseOrder())

    val size = readln().toInt()
    for (i in 0..<size) {
        val data = readln().toInt()
        if (data == 0) {
            if (priorityQueue.isEmpty()) {
                sb.append("0").append("\n")
            } else {
                sb.append(priorityQueue.remove()).append("\n")
            }
        } else {
            priorityQueue.add(data)
        }
    }
    print(sb)
}