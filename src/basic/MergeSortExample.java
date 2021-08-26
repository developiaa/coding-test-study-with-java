package basic;

import java.util.Arrays;

public class MergeSortExample {

    public static void main(String[] args) {
        int[] testArr = {25, 34, 22, 3, 7, 9, 10, 24, 17, 15, 1};

        mergeSort(testArr, 0, testArr.length - 1);
        System.out.println(Arrays.toString(testArr));
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            // divide and conquer 분할정복
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = start;

        int[] temp = new int[arr.length];

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= end) {
            temp[k++] = arr[j++];
        }

        for (int m = start; m <= end; m++) {
            arr[m] = temp[m];
        }
    }

}
