package leetcode.No4;
//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
//
// 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
//
// 你可以假设 nums1 和 nums2 不会同时为空。
//
//
//
// 示例 1:
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
//
//
// 示例 2:
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
//
// Related Topics 数组 二分查找 分治算法

import java.util.Arrays;

/**
 * @author JoanneGeng
 * @date 2020/8/3
 **/
public class FindMedianSortedArrays {

    /**
     * 使用哨兵合并两个有序数组
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {


        int totalLength = nums1.length + nums2.length;

        int[] newNums = new int[totalLength];

        int[] newnums1 = new int[nums1.length + 1];
        int[] newnums2 = new int[nums2.length + 1];

        for (int i = 0; i < nums1.length; i++) {
            newnums1[i] = nums1[i];
        }

        for (int j = 0; j < nums2.length; j++) {
            newnums2[j] = nums2[j];
        }

        newnums1[nums1.length] = Integer.MAX_VALUE;
        newnums2[nums2.length] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int k = 0;


        while (k < totalLength) {

            if (newnums1[i] < newnums2[j]) {

                newNums[k++] = newnums1[i++];
            } else {

                newNums[k++] = newnums2[j++];
            }
        }


        if (totalLength % 2 != 0) { // 奇数

            return newNums[totalLength / 2];

        } else { // 偶数
            return (newNums[totalLength / 2] + newNums[totalLength / 2 - 1]) / 2.0;
        }


    }

    /**
     * 二分查找
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {

        int[] newnums1 = new int[nums1.length + 1];
        int[] newnums2 = new int[nums2.length + 1];

        //Arrays.copyOf(nums1, nums1.length + 1); 自己写转换 貌似快一点
        for (int i = 0; i < nums1.length; i++) {
            newnums1[i] = nums1[i];
        }

        for (int j = 0; j < nums2.length; j++) {
            newnums2[j] = nums2[j];
        }

        newnums1[nums1.length] = Integer.MAX_VALUE;
        newnums2[nums2.length] = Integer.MAX_VALUE;

        boolean even = (nums1.length + nums2.length) % 2 == 0; // 偶数

        int left = (nums1.length + nums2.length) / 2;

        int i = 0;
        int j = 0;

        int pivot = 0;

        int befor = 0;

        int k = 0;


        while (k <= left) {

            if (even) {

                befor = pivot;

            }


            if (newnums1[i] < newnums2[j]) {
                pivot = newnums1[i++];

            } else {
                pivot = newnums2[j++];
            }

            k++;

        }

        if (even) {
            return (pivot + befor) / 2.0;
        } else {
            return pivot;
        }


    }

    public static void main(String[] args) {
        int[] nums1 = {1, 6};
        int[] nums2 = {1, 2, 5, 7, 8, 9};


        System.out.println(findMedianSortedArrays1(nums1, nums2));
        System.out.println(findMedianSortedArrays2(nums1, nums2));


    }


}
