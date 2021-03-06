package base.cha4_bsearch;

/**
 * 查找第一个大于等于给定值的元素
 *
 * @author JoanneGeng
 * @date 2020/7/13
 **/
public class BSearchFirstMin {

    public static int bSearchFirst(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if (a[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == 0 || a[mid -1] < value) return mid;
                else high = mid -1;

            }

        }
        return -1;

    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 7, 7, 7, 7, 7, 9, 10};
        int result1 = bSearchFirst(a, a.length, 7);
        System.out.println(result1);
    }
}
