package Baekjoon.Baekjoon_6064

fun main() {
    val toKotlin = Problem6064ToKotlin()
    val size = readln().toInt()
    val sb = StringBuilder()

    for (i in 1..size) {
        val data = readln().split(" ")
        sb.append(toKotlin.solve(data[0].toInt(), data[1].toInt(), data[2].toInt(), data[3].toInt())).append("\n")
    }
    print(sb)
}

class Problem6064ToKotlin {
    fun solve(m: Int, n: Int, x: Int, y: Int): Int {
        val lcm = lcm(m, n)
        var newX = x
        var newY = y

        while (newX != newY) {
            if (newX < newY) {
                newX += m
            } else {
                newY += n
            }
            if (newX > lcm) {
                return -1
            }
        }

        return newX
    }


    private fun gcd(a: Int, b: Int): Int {
        if (b == 0) return a
        return gcd(b, a % b)
    }

    private fun lcm(a: Int, b: Int): Int {
        return a * b / gcd(a, b)
    }

}