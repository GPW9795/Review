package sort;

import java.util.Arrays;

/**
 * 归并排序（不稳定）
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(n)
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {12, 34, 13, 5, 0, 9, 7, 1, 4, 57, 4};
        sort(arr, new int[arr.length], 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int[] ref, int begin, int end) {
        if (arr == null || arr.length == 0 || begin >= end) return;
        int mid = begin + (end - begin) / 2;
        sort(arr, ref, begin, mid);
        sort(arr, ref, mid + 1, end);
        help(arr, ref, begin, mid, end);
    }

    public static void help(int[] arr, int[] ref, int begin, int mid, int end) {
        int l = begin, r = mid + 1;
        int i = begin;
        while (l <= mid && r <= end) {
            if (arr[l] < arr[r]) {
                ref[i++] = arr[l++];
            } else {
                ref[i++] = arr[r++];
            }
        }
        while (l <= mid) {
            ref[i++] = arr[l++];
        }
        while (r <= end) {
            ref[i++] = arr[r++];
        }
        for (int j = begin; j <= end; j++) {
            arr[j] = ref[j];
        }
    }
}
