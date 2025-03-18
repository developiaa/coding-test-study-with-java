package baekjoon._1181;


import java.util.*;

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
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = sc.next();
        }

        Arrays.sort(words, (o1, o2) -> {
                    if (o1.length() == o2.length()) {
                        return o1.compareTo(o2);
                    }
                    return o1.length() - o2.length();
                }
        );

        System.out.println(words[0]);
        for (int i = 1; i < N; i++) {
            if (!Objects.equals(words[i - 1], words[i])) {
                System.out.println(words[i]);
            }
        }
    }
}
