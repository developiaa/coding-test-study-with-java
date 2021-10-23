package codility.lesson15;


public class CountDistinctSlices2 {
    public static void main(String[] args) {
        int M = 6;
        int[] A = {3, 4, 5, 5, 2};
        System.out.println(solution(M, A));
    }

    public static int solution(int M, int[] A) {
        int start = 0;
        int end = 0;
        boolean[] memo = new boolean[M + 1];
        int count=0;
        while (start < A.length && end < A.length) {
            if(memo[A[end]]){
                memo[A[start]] = false;
                start++;
            }else{
                memo[A[end]] = true;
                count += (end - start + 1);
                end++;
            }
            //최대 갯수가 10억
            //빼면 퍼포먼스 90%
            if(count>1000000000){
                return 1000000000;
            }
        }
        return count;
    }
}
