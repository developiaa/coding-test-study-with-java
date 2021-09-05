package codility.lesson3;

public class FrogJmp {
    public static void main(String[] args) {
//        System.out.println(solution(10, 85, 30));
        System.out.println(solution(3, 999111321, 7));
    }
    // 이렇게 풀면 매우 큰 수의 경우 타임 아웃 에러
    // For example, for the input (3, 999111321, 7) the solution exceeded the time limit.
//    public static int solution(int X, int Y, int D) {
//        int index = 0;
//        while (X < Y) {
//            X = X + D;
//            index++;
//        }
//        return index;
//
//    }

    public static int solution(int X, int Y, int D) {
        int A = (Y-X)/D;
        int B = (Y-X)%D;
        if(B >0){
            A+=1;
        }
        return A;
    }
}
