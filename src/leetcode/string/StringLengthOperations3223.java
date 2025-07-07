package leetcode.string;

public class StringLengthOperations3223 {
    public static void main(String[] args) {
        String s="abaacbcbb";
        System.out.println(minimumLength(s));
    }
    public static int minimumLength(String s) {
        int[] count = new int[26];
        int n = s.length();
        for (int i = 0; i < s.length(); ++i) {
            int ind = s.charAt(i) - 'a';
            ++count[ind];
            if (count[ind] == 3) {
                n -=  2;
                count[ind] = 1;
            }
        }
        return n;
    }
}
