package programmers.test.n2209;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2_3 {
    public static void main(String[] args) {
//        String currentDirectory = "/test/task/java";
//        String command = "cd /test/task"; // /test/task

//        String currentDirectory = "/dev/task/abc/def";
//        String command = "cd /../wow/"; // /wow

        String currentDirectory = "/dev/task/abc/def";
        String command = "cd ../wow/.."; // /dev/task/abc

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
        // 파이썬 변경
        String[] s = command.split(" ");
        if (!s[0].equals("cd")) {
            throw new IllegalStateException();
        }

        if (s[1].length() >= 2 && s[1].charAt(s[1].length() - 1) == '/') {
            s[1] = s[1].substring(0, s[1].lastIndexOf('/')+1);
        }

        if (currentDirectory.length() >= 2 && currentDirectory.lastIndexOf("/") != -1) {
            currentDirectory = currentDirectory.substring(0, currentDirectory.length() - 1);
        }

        String[] split = s[1].split("/");
        System.out.println(Arrays.toString(split));

        List<String> list = new ArrayList<>();
        if (s[1].startsWith("/")) {
            list = new ArrayList<>();
            list.add("");
        } else {
            String[] split1 = currentDirectory.split("/");
            for (int i = 0; i < split1.length; i++) {
                list.add(split1[i]);
            }
        }

        int temp = 0;
        while (temp < split.length) {
            if (split[temp].equals("..")) {
                if (list.lastIndexOf("") != -1) {
                    list = new ArrayList<>();
                    list.add("");
                }
            } else {
                list.add(split[temp]);
                split = remove(split, temp);
                temp -= 1;
            }
            temp += 1;

        }

        if (list.size() == 1 && temp == split.length) {
            return "/";
        }


        for (int i = temp; i < split.length; i++) {
            list.add(split[i]);
        }

        StringBuilder make = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            make.append("/" + list.get(i));
        }
        return String.join("/", list);
    }

    private static String[] remove(String[] arr, int index) {
        if (arr == null || index < 0 || index >= arr.length) {
            return arr;
        }

        List<String> result = new ArrayList<>(Arrays.asList(arr));
        result.remove(index);
        return result.toArray(new String[0]);
    }
}
