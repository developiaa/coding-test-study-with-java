package baekjoon._7785;

import java.util.*;

public class Main_preview {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Set<String> set = new HashSet<>();

        while (N-- > 0) {
            String next = sc.next();
            String type = sc.next();
            if (type.equals("enter")) {
                set.add(next);
            } else {
                set.remove(next);
            }
        }

        List<String> list = new ArrayList<>(set);
        list.sort(Comparator.reverseOrder());
        for (String s : list) {
            System.out.println(s);
        }
    }
}
