package leetcode.No6;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @author JoanneGeng
 * @date 2020/8/28
 **/
public class Convert {

    /**
     * 输入: s = "LEETCODEISHIRING", numRows = 4
     * 输出: "LDREOEIIECIHNTSG"
     *
     * info
     * 		Success:
     * 		Runtime:16 ms, faster than 25.47% of Java online submissions.
     * 		Memory Usage:40.6 MB, less than 13.12% of Java online submissions.
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {

        if (numRows < 2) return s;

        ArrayList<StringBuilder> arrayList = new ArrayList<>(numRows);


        for (int i = 0; i < numRows; i++) {
            arrayList.add(new StringBuilder());
        }

        int flag = -1;
        int j = 0;

        for (int i = 0; i < s.length(); i++) {

            char str = s.charAt(i);


            if (arrayList.get(j) == null) {
                arrayList.add(new StringBuilder(str));
            } else {
                arrayList.get(j).append(str);
            }

            if (j == 0 || j == numRows - 1) flag = -flag;

            j += flag;


        }

        return arrayList.stream().collect(Collectors.joining(""));

    }





    public static void main(String[] args) {


        System.out.println("mine:" + convert("LEETCODEISHIRING", 4));

        System.out.println("correct: LDREOEIIECIHNTSG");
    }
}
