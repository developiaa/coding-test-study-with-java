package programmers.test.n2412;


import java.util.*;

public class Solution3 {
    public static void main(String[] args) {
        int N = 4;
        String S = "1B 2C,2D 4D";
        String T = "2B 2D 3D 4D 4A"; // 1,1

//        int N = 3;
//        String S = "1A 1B,2C 4C";
//        String T = "1B"; // 0,1

//        int N = 12;
//        String S = "1A 2A,12A 12A";
//        String T = "12A"; // 1,0

        System.out.println(solution2(N, S, T));
    }

    public static String solution2(int N, String S, String T) {

        // 배의 정보를 저장할 리스트
        List<Set<String>> ships = new ArrayList<>();
        // 공격된 위치를 저장할 집합
        Set<String> hits = new HashSet<>(Arrays.asList(T.split(" ")));


        String[] split = S.split(",");
        for (String ship : split) {
            String[] data = ship.split(" ");
            String temp1 = data[0];
            String temp2 = data[1];

            int temp1Num = Integer.parseInt(temp1.substring(0, temp1.length() - 1));
            int temp1Text = temp1.charAt(temp1.length() - 1) - 'A';
            int temp2Num = Integer.parseInt(temp2.substring(0, temp2.length() - 1));
            int temp2Text = temp2.charAt(temp2.length() - 1) - 'A';


            // 배의 모든 칸을 집합에 저장
            Set<String> shipCells = new HashSet<>();
            for (int row = temp1Num; row <= temp2Num; row++) {
                for (int col = temp1Text; col <= temp2Text; col++) {
                    char c = (char) ('A' + col);
                    shipCells.add(row + "" + c);
                }
            }
            ships.add(shipCells);
        }
        System.out.println(ships);

        // 침몰된 배와 공격당한 배 수 계산
        int sunken = 0, hitButNotSunk = 0;

        for (Set<String> ship : ships) {
            int hitCount = 0;
            for (String cell : ship) {
                if (hits.contains(cell)) {
                    hitCount++;
                }
            }
            if (hitCount == ship.size()) {
                sunken++; // 모든 칸이 공격되었음
            } else if (hitCount > 0) {
                hitButNotSunk++; // 일부 칸만 공격되었음
            }
        }

        // 결과 반환
        return sunken + "," + hitButNotSunk;
    }

    public static String solution(int N, String S, String T) {
        // 배의 정보를 저장할 리스트
        List<Set<String>> ships = new ArrayList<>();
        // 공격된 위치를 저장할 집합
        Set<String> hits = new HashSet<>(Arrays.asList(T.split(" ")));

        // 배 정보 파싱
        String[] shipDescriptions = S.split(",");
        for (String description : shipDescriptions) {
            String[] corners = description.split(" ");
            String topLeft = corners[0];
            String bottomRight = corners[1];

            // 좌표 파싱
            int startRow = Integer.parseInt(topLeft.substring(0, topLeft.length() - 1));
            int startCol = topLeft.charAt(topLeft.length() - 1) - 'A';
            int endRow = Integer.parseInt(bottomRight.substring(0, bottomRight.length() - 1));
            int endCol = bottomRight.charAt(bottomRight.length() - 1) - 'A';

            // 배의 모든 칸을 집합에 저장
            Set<String> shipCells = new HashSet<>();
            for (int row = startRow; row <= endRow; row++) {
                for (int col = startCol; col <= endCol; col++) {
                    shipCells.add(row + "" + (char) ('A' + col));
                }
            }
            ships.add(shipCells);
        }

        // 침몰된 배와 공격당한 배 수 계산
        int sunken = 0, hitButNotSunk = 0;

        for (Set<String> ship : ships) {
            int hitCount = 0;
            for (String cell : ship) {
                if (hits.contains(cell)) {
                    hitCount++;
                }
            }
            if (hitCount == ship.size()) {
                sunken++; // 모든 칸이 공격되었음
            } else if (hitCount > 0) {
                hitButNotSunk++; // 일부 칸만 공격되었음
            }
        }

        // 결과 반환
        return sunken + "," + hitButNotSunk;
    }
}
