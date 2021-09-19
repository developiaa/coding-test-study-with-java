package codility.lesson6;

//A[0]=-3
//A[1]=1
//A[2]=2
//A[3]=-2
//A[4]=5
//A[5]=6

//조합으로 풀기..
//44%..
public class MaxProductOfThree {
    public static void main(String[] args) {
        int[] A = {-3, 1, 2, -2, 5, 6}; //60
        System.out.println(solution(A));
    }

    static int max = Integer.MIN_VALUE;

    public static int solution(int[] A) {
        int n = A.length;
        int r = 3;
        // 크기가 5인 수열 arr에서 r인 3r개를 뽑은 경우를 출력한다.
        int[] combArr = new int[n]; // 뽑은 원소의 인덱스를 저장하는 배열

        doCombination(combArr, n, r, 0, 0, A);
        return max;
    }

    public static void doCombination(int[] combArr, int n, int r, int index, int target, int[] arr) {
        if (r == 0) {
            // 다 뽑았을 때
            int temp = 1;
            for (int i = 0; i < index; i++)
                temp = temp * arr[combArr[i]];

            if (max < temp) {
                max = temp;
            }
        } else if (target == n) {
            return;
            //r개를 다 못뽑았는데 arr의 모든 원소를 다 검사했을 때, 실패 -> 아무것도 안하고 끝난다.
        } else {
            combArr[index] = target;
            doCombination(combArr, n, r - 1, index + 1, target + 1, arr); // (i) 원소를 뽑는 경우
            doCombination(combArr, n, r, index, target + 1, arr); // (ii) 원소를 안뽑는 경우
        }
    }

}
