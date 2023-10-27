package Baekjoon.Baekjoon_21736

import java.util.LinkedList
import java.util.Queue

fun main() {
    val split = readln().split(" ")
    val y = split[0].toInt()
    val x = split[1].toInt()
    var positionNow: Position? = null
    val data = Array(y) { CharArray(x) }
    val isVisit = Array(y) { BooleanArray(x) }
    var count: Int = 0
    for (i in 0..<y) {
        val readData = readln().toCharArray()
        for (j in 0..<x) {
            if (readData[j] == 'I') {
                positionNow = Position(j, i)
            }
            data[i][j] = readData[j]
        }
    }

    val queue: Queue<Position> = LinkedList()
    queue.add(positionNow)
    isVisit[positionNow!!.y][positionNow.x] = true

    while (queue.isNotEmpty()) {
        val now = queue.remove()
        val xNow = now.x
        val yNow = now.y

        if (xNow - 1 >= 0 && !isVisit[yNow][xNow - 1]) {
            isVisit[yNow][xNow - 1] = true;
            if (data[yNow][xNow - 1] != 'X') {
                queue.add(Position(xNow - 1, yNow));
                if (data[yNow][xNow - 1] == 'P') {
                    count++;
                }
            }
        }

        if (yNow - 1 >= 0 && !isVisit[yNow - 1][xNow]) {
            isVisit[yNow - 1][xNow] = true;
            if (data[yNow - 1][xNow] != 'X') {
                queue.add(Position(xNow, yNow - 1));
                if (data[yNow - 1][xNow] == 'P') {
                    count++;
                }
            }
        }

        if (xNow + 1 < x && !isVisit[yNow][xNow + 1]) {
            isVisit[yNow][xNow + 1] = true;
            if (data[yNow][xNow + 1] != 'X') {
                queue.add(Position(xNow + 1, yNow));
                if (data[yNow][xNow + 1] == 'P') {
                    count++;
                }
            }
        }

        if (yNow + 1 < y && !isVisit[yNow + 1][xNow]) {
            isVisit[yNow + 1][xNow] = true;
            if (data[yNow + 1][xNow] != 'X') {
                queue.add(Position(xNow, yNow + 1));
                if (data[yNow + 1][xNow] == 'P') {
                    count++;
                }
            }
        }
    }

    if (count == 0) {
        println("TT")
    } else {
        println(count)
    }

}

class Position(val x: Int, val y: Int)
