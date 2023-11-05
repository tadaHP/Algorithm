package Baekjoon.Baekjoon_15654

val sb: StringBuilder = StringBuilder()
var size: Int = 0
var target: Int = 0
var newIsVisit: BooleanArray = BooleanArray(0)
var answers: IntArray = IntArray(0)
var newNum: IntArray = IntArray(0)


fun main() {
    val split = readln().split(" ")
    size = split[0].toInt()
    target = split[1].toInt()

    val num = IntArray(size + 1)
    val isVisit = BooleanArray(size + 1)
    newNum = IntArray(size - 1)
    newIsVisit = BooleanArray(size - 1)
    answers = IntArray(target)

    val input = readln().split(" ")
    for (i in 1..size) {
        num[i] = input[i - 1].toInt()
    }
    num.sort()

    for (i in 1..size) {
        answers[0] = num[i]
        isVisit[i] = true
        makeNewArray(num, isVisit)
        solve(target, 1)
        isVisit[i] = false
    }
    print(sb)
}

fun makeNewArray(num: IntArray, isVisit: BooleanArray) {
    var count = 0
    for (i in 1..size) {
        if (!isVisit[i]) {
            newNum[count] = num[i]
            count++
        }
    }
}

fun solve(target: Int, deep: Int) {
    if (deep == target) {
        print()
        return
    }
    for (i in 0..<size - 1) {
        if (!newIsVisit[i]) {
            newIsVisit[i] = true
            answers[deep] = newNum[i]
            solve(target, deep + 1)
            newIsVisit[i] = false
        }
    }
}

fun print() {
    for (i in 0..<target) {
        sb.append(answers[i]).append(" ")
    }
    sb.append("\n")
}