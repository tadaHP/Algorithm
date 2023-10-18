package Baekjoon.Baekjoon_9461

import java.lang.StringBuilder

fun main() {
    val size = readln().toInt()
    val sb = StringBuilder()
    val padobanSequence = makePadobanSequence()

    for (i in 0..<size) {
        sb.append(padobanSequence[readln().toInt()]).append("\n")
    }

    print(sb)

}

fun makePadobanSequence(): LongArray {
    val padobanSequence = LongArray(101)
    padobanSequence[1] = 1;
    padobanSequence[2] = 1;
    padobanSequence[3] = 1;
    padobanSequence[4] = 2;
    padobanSequence[5] = 2;
    padobanSequence[6] = 3;
    padobanSequence[7] = 4;
    padobanSequence[8] = 5;
    padobanSequence[9] = 7;
    padobanSequence[10] = 9;

    for (i in 11..<101) {
        padobanSequence[i] = padobanSequence[i - 1] + padobanSequence[i - 5]
    }

    return padobanSequence
}