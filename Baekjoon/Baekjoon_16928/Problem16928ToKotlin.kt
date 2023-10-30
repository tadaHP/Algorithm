package Baekjoon.Baekjoon_16928

import java.util.LinkedList
import java.util.Queue

fun main() {
    val split = readln().split(" ")
    val radderSize = split[0].toInt()
    val snakeSize = split[1].toInt()
    val board = IntArray(100 + 1)
    val isVisit = BooleanArray(100 + 1)
    val moveInfo = IntArray(100 + 1)


    for (i in 0..<radderSize) {
        val data = readln().split(" ")
        moveInfo[data[0].toInt()] = data[1].toInt()
    }

    for (i in 0..<snakeSize) {
        val data = readln().split(" ")
        moveInfo[data[0].toInt()] = data[1].toInt()
    }

    val queue: Queue<Int> = LinkedList()
    isVisit[1] = true
    board[1] = 0
    queue.add(1)

    while (queue.isNotEmpty()) {
        var now = queue.remove()
        if (now == 100) {
            break
        }
        isVisit[now] = true

        if (moveInfo[now] != 0) {
            val before = now
            now = moveInfo[now];
            isVisit[now] = true;
            board[now] = board[before];
        }

        for (i in 1..6) {
            if (now + i > 100 || isVisit[now + i]) {
                continue;
            }
            queue.add(now + i);
            isVisit[now + i] = true;
            board[now + i] = board[now] + 1;
        }
    }
    print(board[100])
}