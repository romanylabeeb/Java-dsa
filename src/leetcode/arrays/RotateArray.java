package leetcode.arrays;

public class RotateArray {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int m = (n - k % n);
        reverse(nums, 0, m - 1);
        reverse(nums, m, n - 1);
        reverse(nums, 0, n - 1);


    }

    static void reverse(int[] a, int s, int end) {
        while (s < end) {
            int tmp = a[s];
            a[s++] = a[end];
            a[end--] = tmp;
        }
    }

    public static String repeatLimitedString(String s, int k) {
        int[] a = new int[26];
        for (char c : s.toCharArray()) {
            a[c - 'a']++;
        }
        boolean has = true;
        StringBuilder sb = new StringBuilder();
        while (has) {
            has = false;

            for (int i = 25; i >= 0; --i) {
                int rep = a[i];
                if (rep == 0) {
                    continue;
                }
//                "aababab"
                char c = (char) (i + 'a');
                int count = rep < k ? rep : k;
                if (!sb.isEmpty() && sb.charAt(sb.length() - 1) == c) {
                    continue;
                }
                while (count > 0) {
                    sb.append(c);
                    count--;
                }
                has = true;
                a[i] = rep > k ? rep - k : 0;
                if(a[i]>0){
                    for(int j=i-1;j>=0;--j){
                        if(a[j]>0){
                            char cb=(char)(j+'a');
                            sb.append(cb);
                            a[j]--;
                            break;
                        }
                    }
                    i++;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String sa = "aababab";
        int k = 2;
        System.out.println(repeatLimitedString(sa, k));
    }
}
