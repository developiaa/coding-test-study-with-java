package basic;

import java.util.Arrays;

public class MergeSortTest {
    public static void main(String[] args) {
        int[] arr = {34, 17, 9, 4, 51, 6, 8, 9, 12, 11, 30};

        mergeSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }


    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int index = start;

        int[] temp = new int[arr.length];

        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                temp[index++] = arr[i++];
            } else {
                temp[index++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[index++] = arr[i++];
        }

        while (j <= end) {
            temp[index++] = arr[j++];
        }

        for (int a = start; a <= end; a++) {
            arr[a] = temp[a];
        }

    }
}
