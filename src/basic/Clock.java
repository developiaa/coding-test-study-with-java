package basic;

import java.util.*;

public class Clock {
    public static void main(String[] args) {
        //00:00 ~ 23:59
//        System.out.println(sol(1, 8, 3, 2)); //6
//        System.out.println(sol(2, 3, 3, 2)); //3
        System.out.println(sol(6, 2, 4, 7)); //0
    }

    static int COUNT = 0;
    static List<String> result = new ArrayList<>();
    static Set<String> set = new HashSet<>();

    public static int sol(int a, int b, int c, int d) {
        // 모든 시간의 경우의 수 중에서 몇개나 contain 하는 지

        // 첫번째 자리의 수에 따라 두번째 자리의 수가 제한됨
        String[] first = {"0", "1", "2"};
        String[][] second = new String[first.length][];
        for (int i = 0; i < first.length; i++) {
            if (first[i].equals("0") || first[i].equals("1")) {
                second[i] = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
            }
            if (first[i].equals("2")) {
                second[i] = new String[]{"0", "1", "2", "3"};
            }
        }

        String[] third = {"0", "1", "2", "3", "4", "5"};
        String[] fourth = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        int totalCount = 0;

        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second[i].length; j++) {
                for (int k = 0; k < third.length; k++) {
                    for (int l = 0; l < fourth.length; l++) {
                        result.add(first[i] + second[i][j] + third[k] + fourth[l]);
                        totalCount++;
//                        System.out.println(result);
                    }
                }
            }
        }
        System.out.println("totalCount = " + totalCount);
//        System.out.println("result = " + result);

        // a,b,c,d로 가능한 모든 경우의 수 구하기, 순열
        int[] arr = {a, b, c, d};
        permutation(arr, 0, arr.length, 4);

        int resultCount = 0;

        for (Iterator i = set.iterator(); i.hasNext(); ) {
            String value = (String) i.next();
            if (result.contains(value)) {
                resultCount++;
            }
        }
        System.out.println("resultCount = " + resultCount);
        return resultCount;
    }

    public static void permutation(int[] arr, int depth, int n, int r) {
        if (depth == r) {
//            System.out.println(Arrays.toString(arr) + " " + r);
            String value = "";
            for (int i = 0; i < arr.length; i++) {
                value += String.valueOf(arr[i]);
            }
            set.add(value);
            COUNT++;
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    public static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
}
