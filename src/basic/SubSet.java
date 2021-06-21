package basic;

import java.util.Scanner;

// 부분집합(DFS)
// 1부터 N(1<=N<=10)까지 원소를 갖는 집합의 부분집합을 모두 출력
// 재귀를 이용한 완전탐색, 이진트리 전위순회 방식으로 출력
public class SubSet {
    public static int number = 0;
    public static int[] arr = new int[11];

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        number = s.nextInt();
        DFS(1);
    }

    public static void DFS(int L) {
//        if (L == number + 1) {
//            for (int i = 1; i <= number; i++) {
//                if (arr[i] == 1) {
//                    System.out.print(i + " ");
//                }
//            }
//            System.out.println();
//        } else {
//            arr[L] = 1;
//            DFS(L + 1);
//
//            arr[L] = 0;
//            DFS(L + 1);
//        }
        if (L == number + 1) {
            for (int i = 1; i <= number; i++) {
                if (arr[i] == 1) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
            return;
        }

        arr[L] = 1;
        DFS(L + 1);

        arr[L] = 0;
        DFS(L + 1);

    }

}
