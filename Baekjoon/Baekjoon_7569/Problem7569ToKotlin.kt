package Baekjoon.Baekjoon_7569

import java.util.LinkedList
import java.util.Queue

fun main() {
    val split = readln().split(" ")
    val m = split[0].toInt()
    val n = split[1].toInt()
    val h = split[2].toInt()

    val data = Array(h) { Array(n) { IntArray(m) } }
    val isVisited = Array(h) { Array(n) { BooleanArray(m) } }
    val pointQueue: Queue<Point> = LinkedList()

    for (i in 0..<h) {
        for (j in 0..<n) {
            val stringData = readln().split(" ")
            for (k in 0..<m) {
                val point = stringData[k].toInt()
                data[i][j][k] = point
                if (point == 1) {
                    pointQueue.add(Point(i, j, k))
                    isVisited[i][j][k] = true
                }else if (point == -1) {
                    isVisited[i][j][k] = true
                }
            }
        }
    }

    print(Problem7569ToKotlin().solve(pointQueue, isVisited, data, m, n, h))




}

class Problem7569ToKotlin() {
    fun solve(pointQueue: Queue<Point>, isVisited: Array<Array<BooleanArray>>,
              data: Array<Array<IntArray>>, m: Int, n: Int, h: Int): Int {
        while (!pointQueue.isEmpty()) {
            val removedData = pointQueue.remove()
            val xNow = removedData.x;
            val yNow = removedData.y;
            val zNow = removedData.z;

            if (xNow - 1 >= 0 && !isVisited[zNow][yNow][xNow - 1]) {//x-1
                isVisited[zNow][yNow][xNow - 1] = true;
                data[zNow][yNow][xNow - 1] = data[zNow][yNow][xNow] + 1;
                pointQueue.add(Point(zNow, yNow, xNow - 1));
            }
            if (xNow + 1 < m && !isVisited[zNow][yNow][xNow + 1]) {//x+1
                isVisited[zNow][yNow][xNow + 1] = true;
                data[zNow][yNow][xNow + 1] = data[zNow][yNow][xNow] + 1;
                pointQueue.add(Point(zNow, yNow, xNow + 1));
            }
            if (yNow - 1 >= 0 && !isVisited[zNow][yNow - 1][xNow]) {//y-1
                isVisited[zNow][yNow - 1][xNow] = true;
                data[zNow][yNow - 1][xNow] = data[zNow][yNow][xNow] + 1;
                pointQueue.add(Point(zNow, yNow - 1, xNow));
            }
            if (yNow + 1 < n && !isVisited[zNow][yNow + 1][xNow]) {//y+1
                isVisited[zNow][yNow + 1][xNow] = true;
                data[zNow][yNow + 1][xNow] = data[zNow][yNow][xNow] + 1;
                pointQueue.add(Point(zNow, yNow + 1, xNow));
            }
            if (zNow - 1 >= 0 && !isVisited[zNow - 1][yNow][xNow]) {//z-1
                isVisited[zNow - 1][yNow][xNow] = true;
                data[zNow - 1][yNow][xNow] = data[zNow][yNow][xNow] + 1;
                pointQueue.add(Point(zNow - 1, yNow, xNow));
            }
            if (zNow + 1 < h && !isVisited[zNow + 1][yNow][xNow]) {//z+1
                isVisited[zNow + 1][yNow][xNow] = true;
                data[zNow + 1][yNow][xNow] = data[zNow][yNow][xNow] + 1;
                pointQueue.add(Point(zNow + 1, yNow, xNow));
            }
        }

        var min = -1

        for (i in 0..<h) {
            for (j in 0..<n) {
                for (k in 0..<m) {
                    if (!isVisited[i][j][k]) {
                        return -1;
                    }
                    if (min < data[i][j][k]) {
                        min = data[i][j][k];
                    }
                }
            }
        }

        return min - 1
    }
}

class Point(val z: Int, val y: Int, val x: Int)