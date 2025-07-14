package programmers.test.n2506;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(solution(3, 1, 0));
        System.out.println(solution(1, 4, 4));
        System.out.println(solution(1, 3, 0));
        System.out.println(solution(3, 1, 3));
    }


    // 파이썬 코드에서 변환-> 됨
    public static String solution(int A, int B, int C) {
        StringBuilder result = new StringBuilder();
        String last = "", lastLast = "";

        while (A > 0 || B > 0 || C > 0) {
            if (canAdd('a', A, B, C, last, lastLast)) {
                result.append("a");
                A--;
                lastLast = last;
                last = "a";
                continue;
            }

            if (canAdd('b', B, A, C, last, lastLast)) {
                result.append("b");
                B--;
                lastLast = last;
                last = "b";
                continue;
            }

            if (canAdd('c', C, A, B, last, lastLast)) {
                result.append("c");
                C--;
                lastLast = last;
                last = "c";
                continue;
            }


            break;
        }

        return result.toString();
    }

    public static boolean addable(int x, int other) {
        return other >= (int) Math.ceil(x / 2.0) - 1;
    }

    private static boolean canAdd(char target, int count, int other1, int other2, String last, String lastLast) {
        if (count == 0) return false;
        if (last.equals(String.valueOf(target)) && lastLast.equals(String.valueOf(target))) return false;
        return addable(other1, count + other2 - 1) && addable(other2, count + other1 - 1);
    }


//    public static String solution(int A, int B, int C) {
//        int max = Math.max(A, B);
//        max = Math.max(max, C);
//        int total = A + B + C;
//        for (int i = 0; i < total; i++) {
//
//        }
//    }


//    public static String solution(int A, int B, int C) {
//        StringBuilder sb = new StringBuilder();
//        PriorityQueue<Letter> pq = new PriorityQueue<>((l1, l2) -> {
//            if (l1.count != l2.count) return l2.count - l1.count; // count 많은 순
//            return l1.ch - l2.ch; // 사전순 작은 순
//        });
//
//
//        if (A > 0) pq.offer(new Letter('a', A));
//        if (B > 0) pq.offer(new Letter('b', B));
//        if (C > 0) pq.offer(new Letter('c', C));
//
//        while (!pq.isEmpty()) {
//            Letter first = pq.poll();
//            int len = sb.length();
//            if (len >= 2 && sb.charAt(len - 1) == first.ch && sb.charAt(len - 2) == first.ch) {
//                if (pq.isEmpty()) break;
//                Letter second = pq.poll();
//                sb.append(second.ch);
//                second.count--;
//                if (second.count > 0) pq.offer(second);
//                pq.offer(first); // first는 다음에 시도
//            } else {
//                sb.append(first.ch);
//                first.count--;
//                if (first.count > 0) pq.offer(first);
//            }
//        }
//
//        return sb.toString();
//    }
//
//    static class Letter {
//        private char ch;
//        private int count;
//
//        Letter(char ch, int count) {
//            this.ch = ch;
//            this.count = count;
//        }
//    }
}
