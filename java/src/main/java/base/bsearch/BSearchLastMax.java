package base.bsearch;

/**
 * 查找最后一个小于等于给定值的元素
 *
 * @author JoanneGeng
 * @date 2020/7/13
 **/
public class BSearchLastMax {

    public static int bSearchFirst(int[] a, int n, int value) {

        int low = 0;
        int high = n - 1;

        while (low <= high) {

            int mid = low + ((high - low) >> 1);

            if (a[mid] > value) {
                high = mid - 1;

            } else {
                if (mid == n - 1 || a[mid + 1] > value) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 7, 7, 7, 7, 7, 10, 11, 12};
        int result1 = bSearchFirst(a, a.length, 10);
        System.out.println(result1);
    }


}
