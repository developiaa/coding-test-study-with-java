package basic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class basic1 {
    public static void main(String[] args) {
        String[] a = {"A", "B", "C"};
        String[] b = {"B", "E", "F"};

        System.out.println("duplicate(a,b) = " + duplicate(a, b));
    }

    public static int duplicate(String[] before, String[] after) {
        Set<String> set = new HashSet<>();
        for (String s : before) {
            set.add(s);
        }

        for (String s : after) {
            set.remove(s);
        }
        return set.size();
    }
}
