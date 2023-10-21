package Baekjoon.Baekjoon_11286

import java.util.*
import kotlin.math.absoluteValue

fun main() {
    val sb = StringBuilder()
    val queue: Queue<Int> = PriorityQueue { o1, o2 ->
        val absO1 = o1.absoluteValue
        val absO2 = o2.absoluteValue
        if (absO1 == absO2) {
            o1 - o2
        } else absO1 - absO2
    }

    val size = readln().toInt()

    for (i in 0..<size) {
        val data = readln().toInt()
        if (data == 0) {
            if (queue.isEmpty()) {
                sb.append(0).append("\n");
            } else {
                sb.append(queue.remove()).append("\n");
            }
        } else {
            queue.add(data);
        }
    }
    print(sb)
}