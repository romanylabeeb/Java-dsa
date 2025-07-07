package leetcode.string;

public class StringCompress {

    static String compress(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            count++;
            if ((i + 1) == s.length() || s.charAt(i) != s.charAt(i + 1)) {
                sb.append(s.charAt(i)).append(count);
                count = 0;
            }
        }
        return sb.length() >= s.length() ? s : sb.toString();
    }

    public static void main(String[] args) {
        String s="aabbnnmm";
        System.out.println(compress(s));
    }
}
