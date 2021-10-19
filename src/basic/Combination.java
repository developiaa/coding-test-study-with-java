package basic;

public class Combination {
    public static void main(String[] args) {
        int n = 3;  //3가지 숫자중
        int r = 2;  //2개를 뽑음
        int[] input = {1, 2, 3}; //주어진 숫자
        boolean[] visited = new boolean[n];

        combination(3, 2, 0, input, visited);
    }

    //백트래킹 사용
    //start 변수는 기준, start 인덱스를 기준으로 작으면 뽑을 후보에서 제외, 크면 뽑을 후보
    public static void combination(int n, int r, int start, int[] input, boolean[] visited) {
        if (r == 0) {
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    System.out.print(input[i] + " ");
                }
            }
            System.out.println();
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(n, r - 1, i + 1, input, visited);
            visited[i] = false;
        }
    }
}
