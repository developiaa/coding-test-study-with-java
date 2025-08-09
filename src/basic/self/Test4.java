package basic.self;

public class Test4 {
    public static void main(String[] args) {
        String name = "abcdef";

        System.out.println(test1(name));
        System.out.println(reverseStringWithBuilder(name));

    }

    public static String test1(String name) {
        int left = 0;
        int right = name.length() - 1;
        char[] ch = name.toCharArray();

        while (left < right) {
            char temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;

            left++;
            right--;
        }
        return new String(ch);
    }

    public static String reverseStringWithBuilder(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        return new StringBuilder(str).reverse().toString();
    }
}
