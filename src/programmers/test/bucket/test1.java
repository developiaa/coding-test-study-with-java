package programmers.test.bucket;

import java.util.ArrayList;
import java.util.List;

public class test1 {
    public static void main(String[] args) {
        //["Time 0: Go straight 300m and turn right","Time 3: Go straight 100m and turn left","Time 5: Go straight 500m and turn left"]
        String path = "EEESEEEEEENNNN";
        //["Time 1: Go straight 500m and turn right","Time 6: Go straight 300m and turn right"]
//        String path = "SSSSSSWWWNNNNNN";

        System.out.println(solution(path));
    }

    public static String[] solution(String path) {
        String[] compass = {"E", "W", "S", "N"};
        String[] direction = {"left", "right"};
        String[] answer = {};

        // 바뀌는 구간 체크
        List<Integer> list = new ArrayList<>();
        List<String> temp = new ArrayList<>();

        String s = String.valueOf(path.charAt(0));

        for (int i = 0; i < path.length(); i++) {
            String s2 = String.valueOf(path.charAt(i));
            if (!s.equals(s2)) {
                list.add(i);
                s = s2;
            }
        }


        for (int i = 0; i <list.size(); i++) {
            if (i == 0 && list.get(0) < 5) {
                System.out.println("Time " + i + ": Go straight " + (list.get(i) * 100) + "m and turn " + direction(String.valueOf(path.charAt(list.get(i) - 1)),
                        String.valueOf(path.charAt(list.get(i)))));
                continue;
            }
            for (int j = 1; j < path.length(); j++) {
                if (list.get(i) - j <= 5) {
                    int x = list.get(i) - j;
                    System.out.println("Time " + x + ": Go straight " + ((list.get(i)-(list.get(i)-1)) * 100) + "m and turn " + direction(String.valueOf(path.charAt(list.get(i) - 1)),
                            String.valueOf(path.charAt(list.get(i)))));
                    break;
                }
            }
        }



//        for (int i = 0; i < list.size(); i++) {
//            if (i == 0 && list.get(i) < 5) {
//                System.out.println("Time " + i + ": Go straight " + (list.get(i) * 100) + "m and turn " + path.charAt(list.get(i)));
//                continue;
//            }
//            if (list.get(i) < 5) {
//                int x = list.get(i) - i;
//                System.out.println("Time " + x + ": Go straight " + (list.get(i) * 100) + "m and turn " + path.charAt(list.get(i)));
//            }
//        }


//        int index = 0;
//        for (int i = 0; i < list.size(); i++) {
//            if (i == 0 && list.get(i) < 5) {
//                System.out.println("Time " + i + ": Go straight " + (list.get(i) * 100) + "m and turn " + path.charAt(list.get(i)));
//                temp.add("Time " + i + ": Go straight " + (list.get(i) * 100) + "m and turn " + path.charAt(list.get(i)));
//                index++;
//                continue;
//            }
//            if (list.get(i) - index < 5) {
//                int x = list.get(i)-index;
//                System.out.println("Time " + x + ": Go straight " + (list.get(i) * 100) + "m and turn " + path.charAt(list.get(i)));
//            }
//            index++;
//        }
        System.out.println("list = " + list);


//        for (String s1 : answer) {
//            System.out.println(s1.toString());
//        }

        return answer;
    }

    public static String direction(String s1, String s2) {
        if (s1.equals("N")) {
            if (s2.equals("W")) {
                return "left";
            } else {
                return "right";
            }
        }

        if (s1.equals("E")) {
            if (s2.equals("N")) {
                return "left";
            } else {
                return "right";
            }
        }

        if (s1.equals("S")) {
            if (s2.equals("E")) {
                return "left";
            } else {
                return "right";
            }
        }

        if (s1.equals("W")) {
            if (s2.equals("S")) {
                return "left";
            } else {
                return "right";
            }
        }
        return null;
    }
}
