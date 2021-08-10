package offer.no001

import kotlin.math.abs


//给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
//
//
//
// 注意：
//
//
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231−1]。本题中，如果除法结果溢出，则返回 231 − 1
//
//
//
//
// 示例 1：
//
//
//输入：a = 15, b = 2
//输出：7
//解释：15/2 = truncate(7.5) = 7
//
//
// 示例 2：
//
//
//输入：a = 7, b = -3
//输出：0
//解释：7/-3 = truncate(-2.33333..) = -2
//
// 示例 3：
//
//
//输入：a = 0, b = 1
//输出：0
//
// 示例 4：
//
//
//输入：a = 1, b = 1
//输出：1
//
//
//
// 提示:
//
//
// -231 <= a, b <= 231 - 1
// b != 0
//
//
//
//
// 注意：本题与主站 29 题相同：https://leetcode-cn.com/problems/divide-two-integers/
//
//

/**
 *
 * @author JoanneGeng
 * @date 2021/8/3
 **/
object No001 {


    /**
     *
     *
     * 左移的规则只记住一点：丢弃最高位，0补最低位
     * 如果移动的位数超过了该类型的最大位数，那么编译器会对移动的位数取模（取整）。
     * 如对int型移动33位，实际上只移动了33/32=1位。4>>32与4>>0是等价的
     * 当左移的运算数是int 类型时，每移动1位它的第31位就要被移出并且丢弃；
     * 当左移的运算数是long 类型时，每移动1位它的第63位就要被移出并且丢弃。
     * 当左移的运算数是byte 和short类型时，将自动把这些类型扩大为 int 型。（右移也一样）
     * 数学意义
     * 在数字没有溢出的前提下，对于正数和负数，左移一位都相当于乘以2的1次方，左移n位就相当于乘以2的n次方
     *
     * 右移的规则只记住一点：符号位不变，左边补上符号位
     * 按二进制形式把所有的数字向右移动对应的位数，低位移出(舍弃)，高位的空位补符号位，即正数补零，负数补1
     * 例如，如果要移走的值为负数，每一次右移都在左边补1，
     * 如果要移走的值为正数，每一次右移都在左边补0，这叫做符号位扩展（保留符号位）（sign extension ），
     * 在进行右移操作时用来保持负数的符号。
     * 数学意义：右移一位相当于除2，右移n位相当于除以2的n次方。
     *
     */
    fun divide(a: Int, b: Int): Int {
        if (a == 0) return 0
        if (a == Int.MIN_VALUE && b == -1) return Int.MAX_VALUE
        val f = a > 0 && b > 0 || a < 0 && b < 0
        var x = abs(a.toLong())
        val y = abs(b.toLong())
        var ans: Long = 0
        for (i in 31 downTo 0) {
            if (x == 0L) break
            if (x shr i >= y) {
                ans += 1L shl i //
                x -= y shl i
            }
        }
        return if (f) ans.toInt() else (-ans).toInt()
    }

    /**
     *
     */
    fun divide1(a: Int, b: Int): Int {
        if (a == 0) return 0
        if (a == Int.MIN_VALUE && b == -1) return Int.MAX_VALUE
        val f = a > 0 && b > 0 || a < 0 && b < 0
        var x = abs(a)
        val y = abs(b)
        var ans = 0
        for (i in 31 downTo 0) {
            if (x == 0) break
            if (x shr i >= y) {
                ans += 1 shl i
                x -= y shl i
            }
        }
        return if (f) ans else (-ans)
    }

}

fun main() {
    println(No001.divide(-2147483648, -1))
    println(No001.divide1(-2147483648, -1))
    println("=============")
    println(No001.divide(-2147483648, -2))
    println(No001.divide1(-2147483648, -2))
    println("=============")
    println(No001.divide(-2147483648, 2))
    println(No001.divide1(-2147483648, 2))
    println("=============")
    println(No001.divide(-2147483648, 1))
    println(No001.divide1(-2147483648, 1))
}