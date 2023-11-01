package Baekjoon.Baekjoon_1043

var parents: IntArray? = null

fun main() {
    val split = readln().split(" ")
    val personCount = split[0].toInt()
    val partyCount = split[1].toInt()
    var count = 0

    parents = IntArray(personCount + 1)
    val truthPeople = BooleanArray(personCount + 1)
    val party: Array<HashSet<Int>?> = arrayOfNulls(partyCount + 1)
    for (i in 1..partyCount) {
        party[i] = HashSet()
    }

    for (i in 1..personCount) {
        parents!![i] = i
    }

    val truthData = readln().split(" ")
    val truthCount = truthData[0].toInt()
    for (i in 1..truthCount) {
        truthPeople[truthData[i].toInt()] = true
    }

    for (i in 1..partyCount) {
        val data = readln().split(" ")
        val attendCount = data[0].toInt()

        if (attendCount == 1) {
            party[i]?.add(data[1].toInt())
        }
        for (j in 1..<attendCount) {
            val now = data[j].toInt()
            val next = data[j + 1].toInt()
            val nowParent = find(now)
            val nextParent = find(next)
            if (nowParent != nextParent) {
                exchange(now, next)
            }
            party[i]?.add(now)
            party[i]?.add(next)
        }
    }

    for (i in 1..personCount) {
        if (truthPeople[i]) {
            val rootValue = find(i);
            for (j in 1..personCount) {
                if (find(j) == rootValue) {
                    truthPeople[j] = true;
                }
            }
        }
    }

    for (i in 1..partyCount) {
        var isUnknown = true;
        for (person in party[i]!!) {
            if (truthPeople[person]) {
                isUnknown = false
                break
            }
        }
        if (isUnknown) {
            count++;
        }
    }

    println(count)
}

fun find(num: Int) :Int{
    if (parents!![num] == num) {
        return num;
    }
    return find(parents!![num]);
}

fun exchange(now: Int, next: Int) {
    if (parents!![next] != next) {
        exchange(now, parents!![next]);
    }
    parents!![next] = now;
}