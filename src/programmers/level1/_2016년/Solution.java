package programmers.level1._2016년;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Solution {
    public static void main(String[] args) {
//        int a = 5;
//        int b = 24; // TUE
        int a = 2;
        int b = 29; // TUE
        System.out.println(solution(a, b));
    }

    public static String solution(int a, int b) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(Calendar.YEAR, 2016);
        gregorianCalendar.set(Calendar.MONTH, a-1);
        gregorianCalendar.set(Calendar.DATE, b);

        return switch (gregorianCalendar.get(Calendar.DAY_OF_WEEK)) {
            case 1 -> "SUN";
            case 2 -> "MON";
            case 3 -> "TUE";
            case 4 -> "WED";
            case 5 -> "THU";
            case 6 -> "FRI";
            default -> "SAT";
        };
    }
}
