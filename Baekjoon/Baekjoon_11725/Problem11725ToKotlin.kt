package Baekjoon.Baekjoon_11725

import java.util.LinkedList
import java.util.Queue

fun main() {
    val sb = StringBuilder()

    val size = readln().toInt()

    val tree = ArrayList<ArrayList<Int>>()
    val isVisit = BooleanArray(size)
    val temp = IntArray(size)

    for (i in 0..<size) {
        tree.add(ArrayList())
    }

    for (i in 1..<size) {
        val data = readln().split(" ")
        val data1 = data[0].toInt() - 1
        val data2 = data[1].toInt() - 1
        tree[data1].add(data2)
        tree[data2].add(data1)
    }

    val queue: Queue<Int> = LinkedList()
    queue.add(0)
    isVisit[0] = true
    while (queue.isNotEmpty()) {
        val now = queue.remove()
        val visitNow = tree[now]
        for (i in visitNow) {
            if (!isVisit[i]) {
                isVisit[i] = true
                temp[i] = now
                queue.add(i)
            }
        }
    }

    for (i in 1..<size) {
        sb.append(temp[i] + 1).append("\n")
    }

    print(sb)
}