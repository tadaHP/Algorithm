package Baekjoon.Baekjoon_9375

fun main() {
    val testCase = readln().toInt()
    val sb = StringBuilder()

    val p = Problem9375ToKotlin()
    for (i in 0..<testCase) {
        sb.append(p.solve()).append("\n")
    }
    print(sb)
}

class Problem9375ToKotlin {

    fun solve(): Int {
        val wearSize = readln().toInt()
        val item = HashMap<String, Int>()
        for (i in 0..<wearSize) {
            val data = readln().split(" ")
            item.put(data[1], item.getOrDefault(data[1], 0) + 1)
        }
        var multiply: Int = 1
        for (i in item) {
            multiply *= i.value + 1
        }
        return multiply - 1
    }

}