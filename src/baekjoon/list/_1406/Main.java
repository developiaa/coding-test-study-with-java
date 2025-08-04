package baekjoon.list._1406;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] words = sc.next().toCharArray();

        List<Character> list = new LinkedList<>();
        for (char word : words) {
            list.add(word);
        }
        ListIterator<Character> iterator = list.listIterator(list.size());
        int M = sc.nextInt();
        while (M-- > 0) {
            char c = sc.next().charAt(0);
            if (c == 'L') {
                if (iterator.hasPrevious()) {
                    iterator.previous();
                }
            } else if (c == 'D') {
                if (iterator.hasNext()) {
                    iterator.next();
                }
            } else if (c == 'B') {
                if (iterator.hasPrevious()) {
                    iterator.previous();
                    iterator.remove();
                }
            } else if (c == 'P') {
                char word = sc.next().charAt(0);
                iterator.add(word);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character character : list) {
            sb.append(character);
        }
        System.out.println(sb);
    }
}
