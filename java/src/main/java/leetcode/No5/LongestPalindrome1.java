package leetcode.No5;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * Related Topics 字符串 动态规划
 *
 * @author JoanneGeng
 * @date 2020/6/28
 **/
public class LongestPalindrome1 {

    /**
     * 暴力解法
     * <p>时间复杂度：O(N<sup>3</sup>)，这里 N 是字符串的长度，枚举字符串的左边界、右边界，然后继续验证子串是否是回文子串，这三种操作都与 N 相关；
     * <p>空间复杂度：O(1)，只使用到常数个临时变量，与字符串长度无关。
     *
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int max = 1;

        int begin = 0;

        char[] charArray = s.toCharArray();

        for (int i = 0; i < len - 1; i++) {

            for (int j = i + 1; j < len; j++) {

                if ((j - i + 1) > max && isPalindrome(charArray, i, j)) {
                    max = j - i + 1;
                    begin = i;
                }
            }


        }

        return s.substring(begin, begin + max);


    }

    /**
     * 验证子串 s[left..right] 是否为回文串
     */
    private static boolean isPalindrome(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
