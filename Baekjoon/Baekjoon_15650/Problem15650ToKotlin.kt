package Baekjoon.Baekjoon_15650

val sb = StringBuilder()
var isVisit: BooleanArray = BooleanArray(0)
var size: Int = 0

fun main() {

    val split = readln().split(" ")
    size = split[0].toInt()
    val target = split[1].toInt()
    isVisit = BooleanArray(size + 1)

    for (i in 1..<size + 2 - target) {
        isVisit[i] = true
        solve(i, 1, target)
        isVisit[i] = false
    }
    print(sb)
}

fun solve(start: Int, deep: Int, target: Int) {
    if (deep == target) {
        print()
        return
    }
    for (i in start + 1..size) {
        isVisit[i] = true
        solve(i, deep + 1, target)
        isVisit[i] = false
    }

}

fun print() {
    for (i in 1..size) {
        if (isVisit[i]) {
            sb.append(i).append(" ")
        }
    }
    sb.append("\n")
}