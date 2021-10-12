package basic;

public class recursive {
    public static void main(String[] args) {
        System.out.println(sum(5));
        System.out.println(sum2(5));
    }

    public static int sum(int num) {
        if (num == 1) {
            return 1;
        }
        return num + sum(num - 1);
    }

    public static int sum2(int num) {
        return (num * (num + 1)) / 2;
    }

}
