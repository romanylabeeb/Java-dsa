package leetcode.string;

public class ROtateString {
    static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        StringBuilder sb = new StringBuilder();
        int n = s1.length();

        for (int i = 0; i < n; ++i) {
            if (s1.charAt(i) == s2.charAt(0) && isValidRotation(s1, s2, i, sb)) {
                return true;
            }
            sb.append(s1.charAt(i));
        }
        return false;
    }

    private static boolean isValidRotation(String s1, String s2, int i, StringBuilder sb) {
        String xy = s1.substring(i)+sb.toString() ;
        return xy.equals(s2);
    }

    public static void main(String[] args) {
        String s1="waterbottle";
        String s2="tlewaterbotr";
        System.out.println(isRotation(s1,s2));
    }
}
