package leetcode.No6

/**
 *
 * @author JoanneGeng
 * @date 2020/8/28
 **/
fun convert(s: String, numRows: Int): String {

    if (numRows < 2) return s


    var flag = -1

    var j = 0

    val list = mutableListOf<StringBuilder>()

    for (i in 0 until numRows) list.add(StringBuilder())

    for (c in s) {

        list[j].append(c)

        if (j == 0 || j == numRows - 1) flag = -flag

        j += flag

    }

    return list.joinToString("")

}

fun main() {
    println("mine   : " + convert("LEETCODEISHIRING", 4))

    println("correct: LDREOEIIECIHNTSG")
}


