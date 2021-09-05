package codility.lesson2;


public class OddOccurrencesInArray2 {
    public static void main(String[] args) {
        // int[] A = {9, 3, 9, 3, 9, 7, 9}; // 7
        // int[] A = {3,5,5,3,1}; // 1
         int[] A = {3,1,1,3,7}; // 7
        //int[] A = {7, 3, 7, 3, 9, 1, 1, 3, 3, 1, 1, 3, 3, 11, 1, 33, 3, 5, 5, 11, 1, 33, 3, 7, 7, 99, 101, 99, 101}; // 9
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        int temp =0;
        for(int i=0; i<A.length; i++){
            temp = temp^ A[i];

        }
        return temp;
    }
}
