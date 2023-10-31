package basic;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4, 5};
        System.out.println(binarySearch(arr, 2));
    }

    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length;

        while (end > start) {
            int mid = (start + end) / 2;
            int value = arr[mid];

            if (value == target) {
                return mid;
            } else if (value > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
