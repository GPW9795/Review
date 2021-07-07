package sort;

import java.util.Arrays;

/**
 * 冒泡排序（稳定）
 * 时间复杂度：最差O(n^2)，平均O(n^2)，最好O(n)
 * 空间复杂度：O(1)
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {12, 34, 13, 5, 0, 9, 7, 1, 4, 57, 4};
        sortOptimization(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 优化
     */
    public static void sortOptimization(int[] arr) {
        if (arr == null || arr.length == 0) return;
        for (int i = arr.length - 1; i > 0; i--) {
            boolean flag = true;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = false;
                }
            }
            if (flag) return;
        }
    }
}
