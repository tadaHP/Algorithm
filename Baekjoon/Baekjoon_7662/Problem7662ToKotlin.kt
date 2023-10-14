package Baekjoon.Baekjoon_7662

fun main() {
    val p = Problem7662ToKotlin()
    val T = readln().toInt()
    val sb = StringBuilder()
    for (i in 0..<T) {
        sb.append(p.solve())
    }
    print(sb)
}

class Problem7662ToKotlin {

    fun solve():String {
        val size = readln().toInt()
        val sortedMap = sortedMapOf<Int, Int>()

        for (i in 0..<size) {
            val data = readln().split(" ")
            val intData = data[1].toInt()

            if (data[0] == "I") {
                sortedMap.put(intData, sortedMap.getOrDefault(intData, 0) + 1)
            } else {
                if (sortedMap.isEmpty()) {
                    continue
                }
                var temp: Int
                if (intData == 1) {
                    temp = sortedMap.lastKey()
                } else {
                    temp = sortedMap.firstKey()
                }
                if (sortedMap.put(temp, sortedMap.get(temp)?.minus(1)) == 1) {
                    sortedMap.remove(temp)
                }
            }
        }

        if (sortedMap.isEmpty()) {
            return "EMPTY\n"
        }

        val sb = StringBuilder()

        sb.append(sortedMap.lastKey()).append(" ").append(sortedMap.firstKey()).append("\n")

        return sb.toString()

    }
}