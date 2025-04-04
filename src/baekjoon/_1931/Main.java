package baekjoon._1931;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Meeting[] meetings = new Meeting[N];
        for (int i = 0; i < N; i++) {
            meetings[i] = new Meeting(sc.nextInt(), sc.nextInt());
        }

        // 1. 종료시간이 빠른 회의 먼저
        // 2. 종료시간이 같다면 시작시간이 빠른 회의 먼저
        Arrays.sort(meetings, new Comparator<Meeting>() {

            @Override
            public int compare(Meeting o1, Meeting o2) {
                if (o1.end == o2.end) {
                    return o1.start - o2.start;
                }
                return o1.end - o2.end;
            }
        });

        int cnt = 0;
        int ended = 0; // 마지막 사용 시간

        for (Meeting meeting : meetings) {
            if (ended <= meeting.start) {
                cnt++;
                ended = meeting.end;
            }
        }
        System.out.println(cnt);
    }
}
