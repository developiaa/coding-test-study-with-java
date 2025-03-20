package baekjoon._7785;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Set<String> set = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            String name = sc.next();
            String status = sc.next();
            if (status.equals("enter")) {
                set.add(name);
            } else {
                set.remove(name);
            }
        }
        String[] orderedName = set.toArray(new String[0]);
        for(int i = orderedName.length - 1; i >= 0; i--) {
            System.out.println(orderedName[i]);
        }
    }
}
