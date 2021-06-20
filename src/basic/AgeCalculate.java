package basic;

import java.time.LocalDateTime;
import java.util.Scanner;

public class AgeCalculate {
    public static void main(String[] args) {
        String gender = "W";
        Scanner s = new Scanner(System.in);
        // 780316-2376152
        // 061102-3575393
        String line = s.nextLine();
        String bornYear = line.substring(0, 2);
        int sevenNumber = Integer.parseInt(line.substring(7, 8));
        int nowYear = LocalDateTime.now().getYear();
        System.out.println(nowYear);

        int changeYear = 0;

        // 1900년생, 2000년생 분기
        if (sevenNumber == 1 || sevenNumber == 2) {
            changeYear = Integer.parseInt("19" + bornYear);
        } else if (sevenNumber == 3 || sevenNumber == 4) {
            changeYear = Integer.parseInt("20" + bornYear);
        }

        int age = nowYear - changeYear + 1;

        if (sevenNumber == 1 || sevenNumber == 3) {
            gender = "M";
        }
        System.out.println(age + " " + gender);
    }
}
