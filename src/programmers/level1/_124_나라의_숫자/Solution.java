package programmers.level1._124_나라의_숫자;

@Deprecated(since = "효율성 시간 초과")
// 굳이 배열에 담을 필요가 없었다.
public class Solution {
    public static void main(String[] args) {
//        int n = 1; //1
        int n = 2; //2
//        int n = 3; //4
//        int n = 4; //11
//        int n = 25; //221
        System.out.println(solution(n));
    }

    public static String solution(int n) {
        String[] arr = {"4", "1", "2"};
        String[] strings = new String[n+3];
        strings[1] = "1";
        strings[2] = "2";
        strings[3] = "4";
        for (int i = 4; i <= n; i++) {
            int i1 = i / 3;
            if (i % 3 == 0) {
                strings[i] = strings[i1-1] + arr[i % 3];
            } else {
                strings[i] = strings[i1] + arr[i % 3];
            }
        }

        return strings[n];
    }
}
