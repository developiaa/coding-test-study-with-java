package basic;

public class BinarySearch2 {
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

            if (target > value) {
                start = mid + 1;
            } else if (target == value) {
                return mid;
            } else {
                end = mid;
            }
        }

        return -1;
    }
}
