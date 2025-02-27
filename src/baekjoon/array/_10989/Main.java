package baekjoon.array._10989;

import java.io.*;
import java.util.Scanner;


public class Main {
    // 시간초과
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int len = sc.nextInt();
//        int[] arr = new int[10001];
//        for (int i = 0; i < len; i++) {
//            arr[sc.nextInt()]++;
//        }
//        for (int i = 1; i < 10001; i++) {
//            while (arr[i]-- > 0) {
//                System.out.println(i);
//            }
//        }
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int len = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];
        for (int i = 0; i < len; i++) {
            arr[Integer.parseInt(br.readLine())]++;
        }
        for (int i = 1; i < 10001; i++) {
            while (arr[i]-- > 0) {
                bw.write(i + "\n");
            }
        }
        bw.flush();
    }
}
