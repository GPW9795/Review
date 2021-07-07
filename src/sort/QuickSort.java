package sort;

import java.util.Arrays;

/**
 * 快速排序（不稳定）
 * 时间复杂度：最差O(n^2)，平均O(nlogn)，最好O(nlogn)
 * 空间复杂度：O(logn)
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {12, 34, 13, 5, 0, 9, 7, 1, 4, 57, 4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        sortHelper(arr, 0, arr.length);
    }

    public static void sortHelper(int[] arr, int begin, int end) {
        if (end - begin < 2) return;
        int mid = help(arr, begin, end);
        sortHelper(arr, begin, mid);
        sortHelper(arr, mid + 1, end);
    }

    public static int help(int[] arr, int begin, int end) {
        int pivot = arr[begin];
        end--;
        while (begin < end) {
            while (begin < end) {
                if (arr[end] < pivot) {
                    arr[begin++] = arr[end];
                    break;
                } else {
                    end--;
                }
            }
            while (begin < end) {
                if (arr[begin] > pivot) {
                    arr[end--] = arr[begin];
                    break;
                } else {
                    begin++;
                }
            }
        }
        arr[begin] = pivot;
        return begin;
    }
}
