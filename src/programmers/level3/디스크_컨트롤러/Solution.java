package programmers.level3.디스크_컨트롤러;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}}; // 9
        System.out.println(solution(jobs));

    }

    public static int solution(int[][] rawJobs) {
        Job[] jobs = new Job[rawJobs.length];
        for (int i = 0; i < jobs.length; i++) {
            jobs[i] = new Job(rawJobs[i][0], rawJobs[i][1]);
        }
        Arrays.sort(jobs, Comparator.comparingInt(job -> job.start));
        Queue<Job> queue = new LinkedList<>(Arrays.asList(jobs));
        PriorityQueue<Job> pq = new PriorityQueue<>(Comparator.comparingInt(job -> job.duration));

        int exec = 0;
        int time = 0;

        while (!queue.isEmpty() || !pq.isEmpty()) {
            while (!queue.isEmpty() && queue.peek().start <= time) {
                pq.add(queue.poll());
            }

            if (pq.isEmpty()) {
                time = queue.peek().start;
                continue;
            }
            Job job = pq.poll();
            exec += time + job.duration - job.start;
            time += job.duration;

        }

        return exec / jobs.length;
    }

    private static class Job {
        public final int start;
        public final int duration;

        private Job(int start, int duration) {
            this.start = start;
            this.duration = duration;
        }
    }
}
