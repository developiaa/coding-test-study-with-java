package programmers.test.n2209;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
//        String currentDirectory = "/test/task/java";
//        String command = "cd /test/task"; // /test/task

        String currentDirectory = "/dev/task/abc/def";
        String command = "cd /../wow/"; // /wow

//        String currentDirectory = "/dev/task/abc/def";
//        String command = "cd ../wow/.."; // /dev/task/abc

//        String currentDirectory = "/dev/task";
//        String command = "cd /"; // /

//        String currentDirectory = "/dev/task";
//        String command = "cd .."; // /dev

//        String currentDirectory = "/dev/task";
//        String command = "cd java"; // /dev/task/java

//        String currentDirectory = "/dev/task";
//        String command = "cd ../solution"; // /dev/solution


//        String currentDirectory = "/dev/task/java";
//        String command = "cd ../.."; // /dev

//        String currentDirectory = "/dev/task";
//        String command = "wrong ../.."; // IllegalStateException.class

//        String currentDirectory = "/dev/task";
//        String command = "cd java/"; // /dev/task/java

//        String currentDirectory = "/dev/task";
//        String command = "cd java"; // /dev/task/java

        String solution = solution(currentDirectory, command);
        System.out.println("====================");
        System.out.println("answer : " + solution);
    }

    public static String solution(String currentDirectory, String command) {
        String[] s = command.split(" ");
        if (!s[0].equals("cd")) {
            throw new IllegalStateException();
        }

        System.out.println(Arrays.toString(s));
        System.out.println();

        List<String> list = new ArrayList<>();
        String[] split = currentDirectory.split("/");
        for (String sub : split) {
            if (!sub.equals("")) {
                list.add(sub);
            }
        }
        System.out.println(list);
        System.out.println();


        if (s[1].equals("/")) {
            return "/";
        }

        if (currentDirectory.contains(s[1])) {
            return s[1];
        }


        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < s[1].length(); i++) {
            String s1 = String.valueOf(s[1].charAt(i));
            temp.append(s1);
            if (temp.toString().contains("..")) {
                list.remove(list.get(list.size() - 1));
                temp.setLength(0);
            } else if (temp.toString().endsWith("/") && temp.toString().length() >= 2) {
                list.add(temp.substring(1, temp.length() - 1));
            }
        }

        System.out.println("temp = " + temp);
        list.add(temp.toString());

        System.out.println("list = " + list);

        StringBuilder make = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).startsWith("/")) {
                make.append(list.get(i));
            } else {
                make.append("/" + list.get(i));
            }
        }


        // 마지막 / 제거
        String answer = make.toString();
        if (answer.lastIndexOf('/') == answer.length() - 1) {
            answer = answer.substring(0, answer.lastIndexOf('/'));
        }

        return answer;
    }
}
