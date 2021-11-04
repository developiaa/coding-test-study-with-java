package codility.lesson15;


//by Caterpillar Method
public class AbsDistinct2 {
    public static void main(String[] args) {
        int[] A = {-5, -3, -1, 0, 3, 6};
        System.out.println(solution(A));

    }

    //양 끝단에서 하나씩 줄여가는 방식
    public static int solution(int[] A) {
        int count = 0;
        int head = 0;
        int tail = A.length - 1;

        while (head <= tail) {
            if (head > 0 && A[head] == A[head - 1]) {
                head++;
                continue;
            }

            if (tail < A.length - 1 && A[tail] == A[tail + 1]) {
                tail--;
                continue;
            }


            // A[head], A[tail] 절대값을 비교한다.
            // long으로 비교해야하는 이유는 정수 범위를 넘어가기 때문이다.
            long absHead = Math.abs(Long.valueOf(A[head]));
            long absTail = Math.abs(Long.valueOf(A[tail]));

            if (absHead == absTail) {
                tail--;
                head++;
            } else if (absHead < absTail) {
                tail--;
            } else {
                head++;
            }

            count++;

        }
        return count;
    }
}
