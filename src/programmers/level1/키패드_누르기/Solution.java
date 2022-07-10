package programmers.level1.키패드_누르기;

public class Solution {
    public static void main(String[] args) {
        // LRLLLRLLRRL
//        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
//        String hands = "right";
        // LRLLRRLLLRR
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hands = "left";

        System.out.println(solution(numbers, hands));

    }

    public static String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int left = 10;
        int right = 12;
        for (int number : numbers) {
            if (number == 0) {
                number = 11;
            }
            switch (number % 3) {
                case 0 -> {
                    sb.append("R");
                    right = number;
                }
                case 1 -> {
                    sb.append("L");
                    left = number;
                }
                case 2 -> {
                    int diff1 = Math.abs(number - left);
                    int diff2 = Math.abs(right - number);
                    int distance1 = (diff1 % 3) + (diff1 / 3);
                    int distance2 = (diff2 % 3) + (diff2 / 3);

                    if (distance1 > distance2) {
                        sb.append("R");
                        right = number;
                    } else if (distance1 < distance2) {
                        sb.append("L");
                        left = number;
                    } else {
                        if (hand.equals("left")) {
                            sb.append("L");
                            left = number;
                        } else {
                            sb.append("R");
                            right = number;
                        }
                    }
                }
            }
        }
        return sb.toString();
    }
}
