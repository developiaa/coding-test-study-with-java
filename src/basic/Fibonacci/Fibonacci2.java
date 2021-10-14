package basic.Fibonacci;

public class Fibonacci2 {
    public static void main(String[] args) {
        long[] arr = new long[100];
        arr[1] = 1L;
        arr[2] = 1L;
        for (int i = 3; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
            System.out.println(arr[i] + " ");
        }
    }
}
