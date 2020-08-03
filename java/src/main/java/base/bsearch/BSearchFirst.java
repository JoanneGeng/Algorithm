package base.bsearch;

/**
 * 查找第一个值等于给定值的元素
 *
 * @author JoanneGeng
 * @date 2020/7/10
 **/
public class BSearchFirst {

    /**
     * 查找第一个value
     *
     * @param a     数组
     * @param n     数组长度
     * @param value 需要查找的数据
     * @return
     */
    public static int bSearchFirst(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {

            int mid = low + ((high - low) >> 1); // (low+high)/2 防止high太大导致溢出，右移替代除法

            if (a[mid] >= value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (low < n && a[low] == value) return low;
        else return -1;
    }

    public static int bSearchFirst2(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1); // (low+high)/2 防止high太大导致溢出，右移替代除法
            if (value > a[mid]) {
                low = mid + 1;
            } else if (value < a[mid]) {
                high = mid - 1;
            } else {
                if (mid == 0 || a[mid - 1] != value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
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
