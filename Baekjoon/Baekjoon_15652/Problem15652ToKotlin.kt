package Baekjoon.Baekjoon_15652

val sb: StringBuilder = StringBuilder()

fun main() {
    val split = readln().split(" ")
    val size = split[0].toInt()
    val target = split[1].toInt()
    val isVisit = IntArray(size + 1)

    for (i in 1..size) {
        isVisit[i]++
        solve(isVisit, size, i, 1, target)
        isVisit[i]--
    }
    print(sb)
}

fun solve(isVisit: IntArray, size: Int, start: Int, deep: Int, target: Int) {
    if (deep == target) {
        print(isVisit, size)
        return
    }

    for (i in start..size) {
        isVisit[i]++
        solve(isVisit, size, i, deep + 1, target)
        isVisit[i]--
    }

}

fun print(isVisit: IntArray, size: Int) {
    for (i in 1..size) {
        for (j in 0..<isVisit[i]) {
            sb.append(i).append(" ")
        }
    }
    sb.append("\n")
}