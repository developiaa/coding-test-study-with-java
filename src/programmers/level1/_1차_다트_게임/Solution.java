package programmers.level1._1차_다트_게임;

public class Solution {
    public static void main(String[] args) {
        String dartResult = "1S2D*3T"; // 37
//        String dartResult = "1D2S#10S"; // 9
//        String dartResult = "1D2S0T"; // 3
//        String dartResult = "1S*2T*3S"; // 23
//        String dartResult = "1D#2S*3S"; // 5
//        String dartResult = "1T2D3D#"; // -4
//        String dartResult = "1D2S3T*"; // 59

        System.out.println(solution(dartResult));
    }

    public static int solution(String dartResult) {
        int[] array = new int[3];
        int index = 0;
        String temp = "";

        for (int i = 0; i < dartResult.length(); i++) {
            switch (dartResult.charAt(i)) {
                case 'S':
                    array[index] = (int) Math.pow(Integer.parseInt(temp), 1);
                    index++;
                    temp = "";
                    break;
                case 'D':
                    array[index] = (int) Math.pow(Integer.parseInt(temp), 2);
                    index++;
                    temp = "";
                    break;
                case 'T':
                    array[index] = (int) Math.pow(Integer.parseInt(temp), 3);
                    index++;
                    temp = "";
                    break;
                case '*':
                    array[index - 1] *= 2;
                    if (index > 1) {
                        array[index - 2] *= 2;
                    }
                    break;
                case '#':
                    array[index - 1] *= -1;
                    break;
                default:
                    temp += String.valueOf(dartResult.charAt(i));
                    break;
            }
        }

        int answer = 0;
        for (int a : array) {
            answer += a;
        }

        return answer;
    }

}
