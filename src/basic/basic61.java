package basic;

import java.util.Scanner;


//특정수 만들기 (MS 인터뷰)
public class basic61 {
    // 받을 값
    public static int length;
    public static int sum;
    public static int[] arr;

    // 제어할 값
    public static int count = 0;
    public static int[] path;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        length = s.nextInt();
        sum = s.nextInt();
        arr = new int[length];
        path = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = s.nextInt();
        }
//        System.out.println(length);
//        System.out.println(sum);
//        System.out.println(Arrays.toString(arr));

        DFS(1, 0);
        if (count != 0) {
            System.out.println("YES : " + count);
        } else {
            System.out.println("NO : -1");
        }

    }

    public static void DFS(int L, int t) {
//        if (t > sum) return;
        if (L == length + 1) {
            if (sum == t) {
                count++;
                for (int i = 0; i < L - 1; i++) {
                    System.out.print(path[i]);
                }
                System.out.println();
            }
        } else {
            path[L - 1] = arr[L - 1];
            DFS(L + 1, t + arr[L - 1]);
            path[L - 1] = -arr[L - 1];
            DFS(L + 1, t - arr[L - 1]);
            path[L - 1] = 0;
            DFS(L + 1, t);
        }
    }
}
