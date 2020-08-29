package base.cha3_sort;

/**
 * 冒泡排序，插入排序，选择排序
 * @author JoanneGeng
 * @date 2020/6/17
 **/
public class Sort1 {


    /**
     * 冒泡排序
     * <p>原地排序
     * <p>稳定
     * <p>最好O(N),最坏O(N<sup>2</sup>),平均O(N<sup>2</sup>)
     * @param a 数组
     * @param n 数组大小
     */
    public static void bubbleSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n; ++i) { // 趟数

            Boolean flag = false;

            for (int j = 0; j < n - i - 1; j++) {

                if (a[j] > a[j + 1]) { // 交换
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true; // 表示有数据交换
                }


            }

            if (!flag) break;

        }


    }

    /**
     * 插入排序
     * <p>原地排序
     * <p>稳定
     * <p>最好O(N),最坏O(N<sup>2</sup>),平均O(N<sup>2</sup>)
     *
     * @param a
     * @param n
     */
    public static void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; i++) {

            int value = a[i];

            int j = i - 1;

            for (; j >= 0; j--) {

                if (a[j] > value) {
                    a[j + 1] = a[j]; // 数据移动
                } else {
                    break;
                }

            }

            a[j + 1] = value;

        }


    }

    /**
     * 选择排序
     * <p>原地
     * <p>不稳定
     * <p>最好O(N<sup>2</sup>),最坏O(N<sup>2</sup>),平均O(N<sup>2</sup>)
     *
     * @param a
     * @param n
     */
    public static void selectionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n - 1; ++i) {

            int minIndex = i;

            for (int j = i + 1; j < n - i - 1; ++j) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;// 找到最小index
                }

            }

            // 交换
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }

    }

    public static void main(String[] args) {
        int[] a = {4, 5, 6, 3, 2, 1};

        Sort1.bubbleSort(a, a.length);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }



    }


}




