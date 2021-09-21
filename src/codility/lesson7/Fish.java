package codility.lesson7;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Fish {
    public static void main(String[] args) {
        // 2
        int[] A = {4, 3, 2, 1, 5, 6};
        int[] B = {0, 1, 0, 0, 1, 0};
        System.out.println(solution(A, B));
    }

    public static int solution(int[] A, int[] B) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (B[i] == 0) {
                if (list.size() == 0) {
                    stack.add(i);
                } else {
                    Integer peek = stack.peek();

                    while (true) {

                        if (A[peek] < A[i]) {
                            stack.pop();
                            stack.add(A[i]);
                            list.add(i);
                        }else{
                            peek= list.get(list.size()-1);
                            list.remove(peek);
                        }

                        if(list.size()==0){
                            break;
                        }


                    }


                }
            }
            if (B[i] == 1) {
                list.add(i);
                stack.add(i);
            }
        }
        return stack.size();
    }
}
