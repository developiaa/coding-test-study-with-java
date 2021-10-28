package codility.lesson5;

import java.util.*;

//62%
public class GenomicRangeQuery {
    public static void main(String[] args) {
        String S = "CAGCCTA";
        int[] P = {2, 5, 0};
        int[] Q = {4, 5, 6};
        System.out.println(Arrays.toString(solution(S, P, Q)));
    }

    public static int[] solution(String S, int[] P, int[] Q) {
        int[] result = new int[P.length];
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("C", 2);
        map.put("G", 3);
        map.put("T", 4);


        for (int i = 0; i < P.length; i++) {
            List<Integer> list = new ArrayList<>();

            for (int j = P[i]; j <= Q[i]; j++) {
                list.add(map.get(String.valueOf(S.charAt(j))));
            }
            list.sort(Comparator.naturalOrder());

            result[i]=list.get(0);
        }

        return result;
    }

}
