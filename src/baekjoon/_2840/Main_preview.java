package baekjoon._2840;

import java.util.Arrays;
import java.util.Scanner;

// 틀림
public class Main_preview {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        char[] visited = new char[N];
        Arrays.fill(visited, ' ');

        int lastIndex = 0;
        int index = 0;
        while (K-- > 0) {
            int i = sc.nextInt();
            index = index + i;
            if (index >= visited.length) {
                index = index % visited.length;
            }

            char c = sc.next().charAt(0);
            if (visited[index] != ' ' && visited[index] != c) {
                System.out.println("!");
                return;
            }
            visited[index] = c;
            lastIndex = index;
        }


        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == ' ') {
                visited[i] = '?';
            }
        }

        for (int i = lastIndex; i >= 0; i--) {
            System.out.print(visited[i]);
        }
        for (int i = visited.length - 1; i > lastIndex; i--) {
            System.out.print(visited[i]);
        }
    }
}
