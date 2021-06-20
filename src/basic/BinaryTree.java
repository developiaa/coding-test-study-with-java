package basic;

public class BinaryTree {
    public static void main(String[] args) {
        depthFirstSearch(1);
    }

    public static void depthFirstSearch(int num) {
        // 8개의 트리인 경우
        if (num > 7) {
            return;
        }
        // 전위순위 출력
        // 1245367
        System.out.print(num);
        depthFirstSearch(2 * num);

        // 중위순위 출력
        // 4251637
        // System.out.print(num);
        depthFirstSearch(2 * num + 1);

        // 후위순위 출력
        // 4526731
        // System.out.print(num);
    }
}
