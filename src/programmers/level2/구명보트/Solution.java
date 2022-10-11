package programmers.level2.구명보트;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
//        int[] people = {70, 50, 80, 50};
//        int limit = 100; //3

//        int[] people = {70, 50, 80};
//        int limit = 100; //3

//        int[] people = {40, 40, 40, 40, 40};
//        int limit = 200; //3

        int[] people = {90, 60, 40, 40, 40};
        int limit = 90; //4

//        int[] people = {60, 60, 50, 50};
//        int limit = 100; //3
        System.out.println(solution(people, limit));
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        while (left < right) {
            if (people[left] + people[right] > limit) {
                right--;
            } else {
                left++;
                right--;
            }
            answer++;
        }
        if (left == right) {
            answer++;
        }
        return answer;
    }
}
