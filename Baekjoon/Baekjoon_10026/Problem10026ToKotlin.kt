package Baekjoon.Baekjoon_10026

import java.util.*

fun main() {
    val n = readln().toInt()
    val data = Array(n) { Array(n) { "" } }
    for (i in 0..<n) {
        val split = readln().split("")
        for (j in 0..<n) {
            data[i][j] = split[j+1]
        }
    }
    val normalCount = getArea(data, n)
    for (i in 0..<n) {
        for (j in 0..<n) {
            if (data[i][j] == "G") {
                data[i][j] = "R"
            }
        }
    }
    val colorBlindnessCount = getArea(data, n)

    print("$normalCount $colorBlindnessCount")

}
fun getArea(data: Array<Array<String>>, n: Int): Int {
    var count: Int = 0
    val isVisit = Array(n) { Array(n) { false } }
    for (i in 0..<n) {
        for (j in 0..<n) {
            if (!isVisit[i][j]) {
                bfs(data, isVisit, i, j, n)
                count++
            }
        }
    }
    return count
}

fun bfs(data: Array<Array<String>>, isVisit: Array<Array<Boolean>>, i: Int, j: Int, n: Int) {
    val queue = LinkedList<Position>()
    queue.add(Position(i, j))
    isVisit[i][j] = true
    while (queue.isNotEmpty()) {
        val removedPosition = queue.remove()
        val x = removedPosition.x
        val y = removedPosition.y
        val target = data[x][y]

        //x+1
        if (x + 1 < n && !isVisit[x + 1][y] && data[x + 1][y] == target) {
            isVisit[x + 1][y] = true;
            queue.add(Position(x + 1, y));
        }
        //x-1
        if (x - 1 >= 0 && !isVisit[x - 1][y] && data[x - 1][y] == target) {
            isVisit[x - 1][y] = true;
            queue.add( Position(x - 1, y));
        }
        //y+1
        if (y + 1 < n && !isVisit[x][y + 1] && data[x][y + 1] == target) {
            isVisit[x][y + 1] = true;
            queue.add( Position(x, y + 1));
        }
        //y-1
        if (y - 1 >= 0 && !isVisit[x][y - 1] && data[x][y - 1] == target) {
            isVisit[x][y - 1] = true;
            queue.add( Position(x, y - 1));
        }
    }
}

data class Position(val x: Int, val y: Int)
