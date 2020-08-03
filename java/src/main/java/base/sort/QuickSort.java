package base.sort;

/**
 * 快排
 * <p>稳定
 * <p>最好O(nlogn)；
 * <p>极端情况[即原数组已经是有序的]会退化到O(N<sup>2</sup>)，大部分情况还是O(nlogn)
 * <p>原地排序
 * @author JoanneGeng
 * @date 2020/6/18
 **/
public class QuickSort {

    public static void quickSort(int[] a, int n) {

        quickSortInternally(a, 0, n - 1);

    }

    public static void quickSortInternally(int[] a, int p, int r) {

        if (p >= r) return;

        // 获取分区点
        int q = partition(a, p, r);

        quickSortInternally(a, p, q - 1);
        quickSortInternally(a, q + 1, r);

    }

    public static int partition(int[] a, int p, int r) {

        int pivot = a[r];

        int i = p;


        for (int j = p; j < r; ++j) {
            if (a[j] < pivot) {

                if (i == j) {
                    ++i;
                } else {
                    int temp = a[j];
                    a[j] = a[i];
                    a[i++] = temp;
                }

            }
        }


        int tmp = a[i];

        a[i] = a[r];

        a[r] = tmp;

        System.out.println("i=" + i);
        return i;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 23, 4, 5, 2, 1, 5};

        quickSort(a, a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }
}
