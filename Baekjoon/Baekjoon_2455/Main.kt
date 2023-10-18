package Baekjoon.Baekjoon_2455

fun main() {
    var count = 0
    var maxCount = 0

        for (i in 0..<4) {
            val split = readln().split(" ")
            val getOut = split[0].toInt()
            val getIn = split[1].toInt()

            count -= getOut
            count += getIn

            if (maxCount < count) {
                maxCount = count
            }

        }

    print(maxCount)
}