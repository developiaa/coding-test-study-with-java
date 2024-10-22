package programmers.pccp.level1.붕대_감기;

public class Solution {
    public static void main(String[] args) {
//        int[] bandage = {5, 1, 5};
//        int health = 30;
//        int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}}; // 5

//        int[] bandage = {3, 2, 7};
//        int health = 20;
//        int[][] attacks = {{1, 15}, {5, 16}, {8, 6}}; // -1

//        int[] bandage = {1, 1, 1};
//        int health = 1;
//        int[][] attacks = {{1, 1}}; // -1

        int[] bandage = {2, 4, 4};
        int health = 100;
        int[][] attacks = {{1, 96}, {18, 1}}; //99


        System.out.println(solution(bandage, health, attacks));
    }

    public static int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int last = bandage[0];
        int temp = 0;
        int j = 0;
        for (int i = 1; i <= attacks[attacks.length - 1][0]; i++) {
            boolean attacked = false;
            if (i == attacks[j][0]) {
                attacked = true;
                int attack = attacks[j][1];
                health = health - attack;
                if (health <= 0) {
                    return -1;
                }
                temp = 0;
                j++;
            }

            if (!attacked) {
                health = health + bandage[1];
                temp++;
                if (temp == last) {
                    temp = 0;
                    health = health + bandage[2];
                }
            }

            if (health >= maxHealth) {
                health = maxHealth;
            }
        }

        return health;
    }
}
