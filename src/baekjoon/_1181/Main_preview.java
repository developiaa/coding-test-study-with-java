package baekjoon._1181;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * i
 * im
 * it
 * no
 * but
 * more
 * wait
 * wont
 * yours
 * cannot
 * hesitate
 */
public class Main_preview {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Set<String> set = new HashSet<String>();
        for (int i = 0; i < N; i++) {
            set.add(sc.next());
        }

        String[] arr = new String[set.size()];
        int index = 0;
        for (String s : set) {
            arr[index++] = s;
        }
        Arrays.sort(arr, (o1, o2) -> {
            int len = o1.length() - o2.length();
            if (len == 0) {
                for (int i = 0; i < o1.length(); i++) {
                    int i1 = o1.charAt(i) - o2.charAt(i);
                    if (i1 > 0) {
                        return 1;
                    } else if (i1 < 0) {
                        return -1;
                    }
                }
            }
            return len;
        });

        for (int i = 0; i < set.size(); i++) {
            System.out.println(arr[i]);
        }
    }

}
