package Baekjoon.Baekjoon_5525

fun main() {
    ToKotlin().solve()
}

class ToKotlin {
    fun solve() {
        val iCount: Int = readln().toInt()
        val length: Int = readln().toInt()
        val data: String = readln()
        val charData = data.toCharArray()

        var count = 0
        var answer = 0
        var i = 1


        while (i < length - 1) {
            if (charData[i] == 'O' && charData[i + 1] == 'I') {
                count++
                if (count == iCount) {
                    if (charData[i - (count * 2) + 1] == 'I') {
                        answer++
                    }
                    count--
                }
                i += 2
            } else {
                count = 0
                i++
            }
        }

        println(answer)
    }
}