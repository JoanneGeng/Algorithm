package base.cha4_bsearch;

/**
 * 查找任意元素
 *
 * @author JoanneGeng
 * @date 2020/7/10
 **/
public class BSearch {


    public static int bSearch(int[] a, int n, int value) {

        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;


    }

    /**
     * 递归实现
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int bSearch1(int[] a, int n, int value) {
        return bSearchInternally(a, 0, n - 1, value);
    }

    private static int bSearchInternally(int[] a, int low, int high, int value) {
        int mid = low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] > value) {
            bSearchInternally(a, low, mid - 1, value);
        } else {
            bSearchInternally(a, mid + 1, high, value);
        }
        return -1;


    }

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 7, 7, 7, 7, 7, 9, 10};
        int result1 = bSearch(a, a.length, 7);
        int result2 = bSearch1(a, a.length, 7);
        System.out.println(result1);
        System.out.println(result2);
    }
}
