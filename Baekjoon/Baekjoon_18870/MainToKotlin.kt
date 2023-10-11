package Baekjoon.Baekjoon_18870

fun main() {
    print(MainToKotlin().solve())
}
class MainToKotlin {
    fun solve() :String{
        val stringBuilder = StringBuilder()
        val size = readln().toInt()

        val data = mutableListOf<Int>()

        val stringData = readln().split(" ")
        for (d in stringData) {
            data.add(d.toInt())
        }

        val sortedData = data.sorted()

        val rankMap = mutableMapOf<Int, Int>()

        var count = 0

        for (i in 0..<size) {
            if (!rankMap.containsKey(sortedData[i])) {
                rankMap.put(sortedData[i], count++)
            }
        }

        for (i in 0..<size) {
            stringBuilder.append(rankMap[data[i]]).append(" ")
        }

        return stringBuilder.toString()
    }
}