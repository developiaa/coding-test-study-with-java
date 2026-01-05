package leetcode._6;

public class Solution {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING"; // PINALSIGYAHRPI
        System.out.println(convert(s, 4));

    }

    public static String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currRow = 0;
        int step = 1;

        for (char c : s.toCharArray()) {
            rows[currRow].append(c);

            if (currRow == numRows - 1) {
                step = -1;
            } else if (currRow == 0) {
                step = 1;
            }

            currRow += step;
        }

        StringBuilder result = new StringBuilder(s.length());
        for (StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();
    }
}
