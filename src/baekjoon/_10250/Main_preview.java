package baekjoon._10250;

import java.util.Scanner;

// 틀림
public class Main_preview {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            int num = sc.nextInt();

            StringBuilder sb = new StringBuilder();
            boolean flag = false;
            if (num % H == 0) {
                sb.append(H);
                flag = true;
            } else {
                sb.append(num % H);
            }
            if ((num / H) < 9 && !flag) {
                sb.append("0" + (1 + num / H));
            } else if ((num / H) < 9) {
                sb.append("0" + (num / H));
            } else {
                sb.append("" + (num / H));
            }

            System.out.println(sb.toString());
        }
    }
}
