package codility.lesson4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PermCheck {
    public static void main(String[] args) {
        //int[] A = {4, 1, 2, 3}; //1
        int[] A = {4, 1, 3}; //0
        System.out.println(solution(A));
    }
    //순열인지(1) 아닌지(0)에 따라서 결과값 반환
    public static int solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        //사실 이렇게 하면 안됨, 왜냐하면 길이랑 최종 값이랑 같아야 하기 때문에 정답은 맞을 순 있지만
        //set의 출력결과가 {1,2,3}이기 때문에 정확하진 않음
        for (int i=1; i<=A.length; i++){
            set.add(i);
        }
        System.out.println(set);
        for (int i=0; i<A.length; i++){
            set.remove(A[i]);
        }
        if(set.isEmpty()){
            return 1;
        }else{
            return 0;
        }
    }

}
