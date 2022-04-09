package basic.nTest;

public class example3 {
    public static void main(String[] args) {
//        String s = "?ab??a"; //aabbaa
//        String s = "bab??a";    //NO
        String s = "bab??a";    //NO

        System.out.println(solution(s));
    }

    public static String solution(String s) {
        String[] strings = new String[s.length()];
        int p = 0;
        int q = s.length() - 1;
        while (p < q) {
            if (s.charAt(p) == '?' && s.charAt(q) != '?') {
                strings[p] = String.valueOf(s.charAt(q));
                strings[q] = String.valueOf(s.charAt(q));
            }
            if (s.charAt(p) != '?' && s.charAt(q) == '?') {
                strings[q] = String.valueOf(s.charAt(p));
                strings[p] = String.valueOf(s.charAt(p));
            }
            if (s.charAt(p) == '?' && s.charAt(q) == '?') {
                strings[p] = "a";
                strings[q] = "a";
            }
            if (s.charAt(p) != '?' && s.charAt(q) != '?') {
                if (s.charAt(p) != s.charAt(q)) {
                    return "NO";
                }
            }
            p++;
            q--;

        }
        StringBuilder answer = new StringBuilder();
        for (String string : strings) {
            answer.append(string);
        }


        return answer.toString();
    }
}
