package Baekjoon.Baekjoon_17219

fun main() {
    val sb = StringBuilder()
    val counts = readln().split(" ")

    val dataSize = counts[0].toInt()
    val askSize = counts[1].toInt()
    val values: HashMap<String, String> = HashMap()

    for (i in 0..<dataSize) {
        val data = readln().split(" ")
        values.put(data[0], data[1])
    }

    for (i in 0..<askSize) {
        sb.append(values.get(readln())).append("\n")
    }
    print(sb)
}