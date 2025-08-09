package basic.self;

public class Test2 {
    public static void main(String[] args) {
        int num1 = 100;
        int num2 = -200;

        System.out.println(getHalf(num1));
        System.out.println(getHalf(num2));

        System.out.println(getTwice(num1));
        System.out.println(getTwice(num2));
    }

    public static int getHalf(int n) {
        return n >> 1;
    }

    public static int getTwice(int n) {
        return n << 1;
    }
}
