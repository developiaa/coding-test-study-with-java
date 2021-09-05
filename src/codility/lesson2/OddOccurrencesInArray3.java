package codility.lesson2;


import java.util.HashSet;
import java.util.Set;

public class OddOccurrencesInArray3 {
    public static void main(String[] args) {
        // int[] A = {9, 3, 9, 3, 9, 7, 9}; // 7
        // int[] A = {3,5,5,3,1}; // 1
         int[] A = {3,1,1,3,7}; // 7
        //int[] A = {7, 3, 7, 3, 9, 1, 1, 3, 3, 1, 1, 3, 3, 11, 1, 33, 3, 5, 5, 11, 1, 33, 3, 7, 7, 99, 101, 99, 101}; // 9
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int i : A) {
            if(set.contains(i)){
                set.remove(i);
            }else{
                set.add(i);
            }
        }
        return set.iterator().next();
    }
}
