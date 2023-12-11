package programmers.level5.방의_개수;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int[] arrows = {6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0}; //3
        System.out.println(solution(arrows));
    }

    private static final int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    private static final int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static int solution(int[] arrows) {
        int count = 0;
        Map<String, Vertex> vertices = new HashMap<>();
        Vertex v = new Vertex(0, 0);
        vertices.put(v.id, v);

        for (int d : arrows) {
            for (int i = 0; i < 2; i++) {
                int x = v.x + dx[d];
                int y = v.y + dy[d];
                String id = Vertex.id(x, y);
                if (!vertices.containsKey(id)) {
                    // 기존에 방문한 적이 없다면 생성
                    vertices.put(id, new Vertex(x, y));
                } else if (!v.connectedVertices.contains(id)) {
                    // 방문한 적이 있다면 간선의 존재 유무 파악
                    count++;
                }

                Vertex u = vertices.get(id);
                v.connectedVertices.add(u.id);
                u.connectedVertices.add(v.id);
                v = vertices.get(id);
            }
        }
        return count;
    }

    private static class Vertex {
        public final int x;
        public final int y;
        public final String id;
        public final Set<String> connectedVertices;

        public Vertex(int x, int y) {
            this.x = x;
            this.y = y;
            this.id = id(x, y);
            this.connectedVertices = new HashSet<>();
        }

        public static String id(int x, int y) {
            return String.format("(%d, %d)", x, y);
        }
    }
}
