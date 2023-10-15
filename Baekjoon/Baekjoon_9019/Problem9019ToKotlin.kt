package Baekjoon.Baekjoon_9019

import java.util.LinkedList
import java.util.Queue

fun main() {
    val size = readln().toInt()
    val sb = StringBuilder()

    for (i in 0..<size) {
        val data = readln().split(" ")
        sb.append(solve(data[0].toInt(), data[1].toInt())).append("\n")
    }
    print(sb)
}

private fun solve(numA: Int, target: Int): String {
    val queue: Queue<Int> = LinkedList()
    val isVisit = BooleanArray(10000)
    val commands = arrayOfNulls<String>(10000)

    queue.add(numA)
    isVisit[numA] = true
    commands[numA] = ""

    while (!queue.isEmpty() && !isVisit[target]) {
        val now = queue.remove()

        val d = functionD(now)
        val s = functionS(now)
        val l = functionL(now)
        val r = functionR(now)

        if (!isVisit[d]) {
            queue.add(d)
            isVisit[d] = true
            commands[d] = commands[now] + "D"
        }
        if (!isVisit[s]) {
            queue.add(s)
            isVisit[s] = true
            commands[s] = commands[now] + "S"
        }
        if (!isVisit[l]) {
            queue.add(l)
            isVisit[l] = true
            commands[l] = commands[now] + "L"
        }
        if (!isVisit[r]) {
            queue.add(r)
            isVisit[r] = true
            commands[r] = commands[now] + "R"
        }
    }

    return commands[target]!!
}

private fun functionD(num: Int): Int = (num * 2) % 10000

private fun functionS(num: Int): Int = if (num==0) 9999 else num - 1

private fun functionL(num: Int): Int = ((num % 1000) * 10) + (num / 1000)

private fun functionR(num: Int): Int = (num / 10) + ((num % 10) * 1000)