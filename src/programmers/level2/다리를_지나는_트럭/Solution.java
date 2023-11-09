package programmers.level2.다리를_지나는_트럭;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6}; // 8

//        int bridge_length = 100;
//        int weight = 100;
//        int[] truck_weights = {10}; // 101

//        int bridge_length = 100;
//        int weight = 100;
//        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10}; // 110
        System.out.println(solution(bridge_length, weight,truck_weights));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int bridgeWeight = 0;
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        int time = 0;
        int truckIndex = 0;
        while (truckIndex < truck_weights.length) {
            bridgeWeight -= bridge.poll();
            int truckWeight = truck_weights[truckIndex];
            if (bridgeWeight + truckWeight <= weight) {
                bridge.add(truckWeight);
                bridgeWeight += truckWeight;
                truckIndex++;
            } else {
                bridge.add(0);
            }
            time++;
        }

        while (bridgeWeight > 0) {
            bridgeWeight -= bridge.poll();
            time++;
        }

        return time;
    }
}
