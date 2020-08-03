package base.bsearch;

/**
 * 查找最后一个值等于给定值的元素
 *
 * @author JoanneGeng
 * @date 2020/7/13
 **/
public class BSearchLast {


    public static int bSearchFirst(int[] a, int n, int value) {

        int low = 0;

        int high = n - 1;

        while (low <= high) {

            int mid = low + ((high - low) >> 1);

            if (value >= a[mid]) {
                low = mid + 1;

            } else {
                high = a[mid] - 1;
            }
        }

        if (high < n && a[high] == value) return high;
        return -1;

    }

    public static int bSearchFirst2(int[] a, int n, int value) {

        int low = 0;

        int high = n - 1;

        while (low <= high) {

            int mid = low + ((high - low) >> 1);

            if (value > a[mid]) {

                low = mid + 1;

            } else if (value < a[mid]) {

                high = mid - 1;

            } else {

                if ((mid == n - 1) || a[mid + 1] != value) return mid;
                else low = mid + 1;

            }


        }

        return -1;

    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 7, 7, 7, 7, 7, 9, 10};
        int result1 = bSearchFirst(a, a.length, 7);
        int result2 = bSearchFirst2(a, a.length, 7);
        System.out.println(result1);
        System.out.println(result2);
    }
}
