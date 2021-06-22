package basic;

import java.util.Arrays;
import java.util.Scanner;

//입력값
//6
//{1,3,5,6,7,10}

//부분집합의 합이 같은 지 확인하는 함수
//{1,3,5,7} = {6,10}

//출력값
//YES

//Level(Depth)이 arr의 length+1과 같다고 생각할 것

public class basic60 {
    public static int number = 0;
    public static int[] arr;
    public static int total = 0;
    public static boolean flag = false;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        number = s.nextInt();
        for (int i = 0; i < number; i++) {
            int temp = s.nextInt();
            arr[i] = temp;
            total += temp;
        }
        System.out.println(number);
        System.out.println(Arrays.toString(arr));

        DFS(1, 0);

        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void DFS(int L, int sum) {
        if (sum > (total / 2)) return;
        if (flag) return;
        if (L == number + 1) {
            if (sum == (total - sum)) {
                flag = true;
            }
        } else {
            DFS(L + 1, sum + arr[L - 1]);
            DFS(L + 1, sum);
        }
    }
}
