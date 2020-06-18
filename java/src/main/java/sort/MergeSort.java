package sort;

/**
 * 归并排序
 *
 * @author JoanneGeng
 * @date 2020/6/18
 **/
public class MergeSort {

    /**
     * @param a
     * @param n
     */
    public void mergeSort(int[] a, int n) {
        mergeSortInternally(a, 0, n);

    }


    public void mergeSortInternally(int[] a, int p, int r) {
        if (p >= r) return;

        int q = (p + r) / 2;

        // 分治递归
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q + 1, r);

        // 将A[p...q]和A[q+1...r]合并为A[p...r]
        merge1(a, p, q, r);

    }

    /**
     * 合并（两个有序数组合并，无哨兵）
     *
     * @param a
     * @param p
     * @param q
     * @param r
     */
    public void merge1(int[] a, int p, int q, int r) {

        int i = p;

        int j = q + 1;

        int k = 0;

        int[] temp = new int[r - p + 1];

        while (i <= q && j <= r) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }

        }

        // 判断哪个数组有剩余数据

        int start = i;

        int end = q;

        if (j <= r) {
            start = j;
            end = r;
        }

        while (start <= end) {
            temp[k++] = a[start++];
        }

        // 把temp copy 回a
        for (int n = 0; n <= r - p; n++) {
            a[p + n] = temp[n++];

        }

    }

    /**
     * 合并（两个有序数组合并，使用哨兵优化）
     *
     * @param arr
     * @param p
     * @param q
     * @param r
     */
    public void merge2(int[] arr, int p, int q, int r) {

        int[] left = new int[q - p + 2];// 申请空间，为哨兵留出一位

        int[] right = new int[r - q + 1]; // 申请空间，为哨兵留出一位

        for (int i = 0; i <= q - p; i++) {
            left[i] = arr[p + i];
        }
        // 第一个数组最后一位添加哨兵（最大值）
        left[q - p + 1] = Integer.MAX_VALUE;

        for (int i = 0; i < r - q; i++) {
            right[i] = arr[q + i];
        }
        // 第二个数组最后一位添加哨兵（最大值）
        right[r - q] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int k = p;

        while (k <= r) {

            // 当左边数组到达哨兵值时，i不再增加，直到右边数组读取完剩余值，同理右边数组也一样
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }


    }

}



