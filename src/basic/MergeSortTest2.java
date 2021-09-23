package basic;

import java.util.Arrays;

public class MergeSortTest2 {
    public static void main(String[] args) {
        int[] A = {4, 34, 12, 3, 2, 200, 17, 55, 31, 49};

        mergeSort(A, 0, A.length - 1);
        System.out.println(Arrays.toString(A));
    }

    public static void mergeSort(int[] arr, int start, int end){

        if(start<end){
            int mid = (start+end)/2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            sort(arr, start, mid, end);
        }
    }

    public static void sort(int[]arr, int start, int mid, int end){
        int i = start;
        int j = mid+1;
        int index = start;

        int[]temp = new int[arr.length];

        while(i<=mid && j<=end){
            if(arr[i]<arr[j]){
                temp[index++] = arr[i++];
            }else{
                temp[index++] = arr[j++];
            }
        }

        while(i<=mid){
            temp[index++] = arr[i++];
        }

        while(j<=end){
            temp[index++] = arr[j++];
        }

        for(int k=start; k<=end; k++){
            arr[k]= temp[k];
        }
    }

}
