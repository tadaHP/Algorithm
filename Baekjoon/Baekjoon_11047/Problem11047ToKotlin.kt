package Baekjoon.Baekjoon_11047

fun main() {
    val split = readln().split(" ")
    val n = split[0].toInt()
    var target = split[1].toInt()
    val coins = Array(n) { 0}

    for (i in 0..<n) {
        coins[i] = readln().toInt()
    }

    coins.sort()

    var count: Int = 0

    var selectCoinPosition = n - 1

    while (target != 0) {
        val selectCoin = coins[selectCoinPosition]
        if (selectCoin <= target) {
            while (target >= selectCoin) {
                target -= selectCoin
                count++
            }
        }
        selectCoinPosition--
    }
    print(count)
}