package Baekjoon.Baekjoon_11727

fun main() {
    val size = readln().toInt()
    val data = IntArray(1000)
    data[0] = 1
    data[1] = 3
    data[2] = 5

    for (i in 3..<size) {
        data[i] = (data[i - 1] + (2 * data[i - 2])) % 10007
    }
    print(data[size - 1])
}