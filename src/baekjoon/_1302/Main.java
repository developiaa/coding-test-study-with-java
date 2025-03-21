package baekjoon._1302;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Map<String, Integer> titles = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String title = sc.next();
            titles.put(title, titles.getOrDefault(title, 0) + 1);
        }

        String maxTitle = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> title : titles.entrySet()) {
            String titleName = title.getKey();
            int count = title.getValue();
            if (count > maxCount || (count == maxCount && titleName.compareTo(maxTitle) < 0)) {
                maxTitle = titleName;
                maxCount = count;
            }
        }

    }
}
