package programmers.level1.성격_유형_검사하기;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
//        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
//        int[] choices = {5, 3, 2, 7, 5}; // TCMA

//        String[] survey = {"TR", "RT", "TR"};
//        int[] choices = {7,1,3}; // RCJA
        String[] survey = {"AN"};
        int[] choices = {7}; // RCJN
        System.out.println(solution(survey, choices));
    }

    public static String solution(String[] survey, int[] choices) {
        // choices index와 동일
        int[] score = {3, 2, 1, 0, 1, 2, 3};

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 0);
        map.put("N", 0);
        map.put("C", 0);
        map.put("F", 0);
        map.put("M", 0);
        map.put("J", 0);
        map.put("R", 0);
        map.put("T", 0);

        for (int i = 0; i < survey.length; i++) {
            String substring = survey[i].substring(0, 1);
            String substring2 = survey[i].substring(1);
            if (choices[i] < 4) {
                map.put(substring, map.get(substring) + score[choices[i] - 1]);
            } else if (choices[i] > 4) {
                map.put(substring2, map.get(substring2) + score[choices[i] - 1]);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        String[][] arr = new String[][]{
                {"R", "T"}, {"C", "F"}, {"J", "M"}, {"A", "N"}
        };

        for (String[] strings : arr) {
            if (map.get(strings[0]) < map.get(strings[1])) {
                stringBuilder.append(strings[1]);
            } else {
                stringBuilder.append(strings[0]);
            }
        }

        return stringBuilder.toString();
    }
}
