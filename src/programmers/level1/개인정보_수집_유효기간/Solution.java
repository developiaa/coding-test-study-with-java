package programmers.level1.개인정보_수집_유효기간;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
//        String today = "2022.05.19";
//        String[] terms = {"A 6", "B 12", "C 3"};
//        String[] privacies = {"2021.05.02 A", "2021.07.01 B",
//                "2022.02.19 C", "2022.02.20 C"}; // [1,3]

//        String today = "2020.01.01";
//        String[] terms = {"Z 3", "D 5"};
//        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D",
//                "2019.07.01 D", "2018.12.28 Z"}; // [1,4,5]

        String today = "2022.12.18";
        String[] terms = {"A 21"};
        String[] privacies = {"2020.3.18 A"};
        System.out.println(Arrays.toString(solution(today, terms, privacies)));

    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, String> map = new HashMap<>();
        for (String term : terms) {
            String[] s = term.split(" ");
            map.put(s[0], s[1]);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] s = privacies[i].split(" ");
            String month = map.get(s[1]);
            String calculatedDate = calculateMonth(s[0], month);
            System.out.println(calculatedDate);
            if (isExpired(today, calculatedDate)) {
                list.add(i + 1);
            }
        }

        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static String calculateMonth(String date, String month) {
        String[] splitDate = date.split("\\.");
        int newMonth = Integer.parseInt(splitDate[1]) + Integer.parseInt(month);

        if (newMonth >= 13) {
            if (newMonth % 12 == 0) {
                splitDate[0] = String.valueOf(Integer.parseInt(splitDate[0]) + (newMonth / 12) - 1);
                splitDate[1] = String.valueOf(Integer.parseInt(splitDate[1]) + Integer.parseInt(month) % 12);
            } else {
                splitDate[0] = String.valueOf(Integer.parseInt(splitDate[0]) + newMonth / 12);
                splitDate[1] = String.valueOf(newMonth % 12);
            }

        } else {
            splitDate[1] = String.valueOf(newMonth);
        }


        // 이 날짜 부터 안됨
        return splitDate[0] + "." + splitDate[1] + "." + splitDate[2];
    }

    public static boolean isExpired(String today, String date) {
        // today가 같거나 크면 expired(true)
        //today = "2022.05.19";

        // 2022.06.28 today
        // 2022.07.01 expired
        String[] todaySplit = today.split("\\.");
        String[] dateSplit = date.split("\\.");


        if (Integer.parseInt(todaySplit[0]) > Integer.parseInt(dateSplit[0])) {
            return true;
        } else if (Integer.parseInt(todaySplit[0]) == Integer.parseInt(dateSplit[0])) {
            if (Integer.parseInt(todaySplit[1]) > Integer.parseInt(dateSplit[1])) {
                return true;
            } else if (Integer.parseInt(todaySplit[1]) == Integer.parseInt(dateSplit[1])) {
                return Integer.parseInt(todaySplit[2]) >= Integer.parseInt(dateSplit[2]);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
