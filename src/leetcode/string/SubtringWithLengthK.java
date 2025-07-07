package leetcode.string;

import java.util.HashSet;
import java.util.Set;

public class SubtringWithLengthK {
    // leetcode 1100
    // suig pointer
    public static int getSubStringCountWithLengthK(String s,int k){
        if (s.length()<k)return 0;
        Set<Character> set=new HashSet<>();
      int total=0;
        int left=0;
        for(int r=0;r<s.length();r++){
            char c=s.charAt(r);
            while (set.contains(c)|| r-left+1>k){
                set.remove(s.charAt(left++));
            }
            set.add(c);
            if(set.size()==k){
                total++;
            }
        }

        return total;
    }
    public static int getSubStringCountWithLengthKUseSlidingWindow(String s,int k) {
        if (s.length() < k) return 0;
        int[]freq=new int[26];
        int total=0;
        int l=0;
        for(int i=0;i<s.length();i++){
            int curPointer=s.charAt(i)-'a';
            ++freq[curPointer];
            while(freq[curPointer]>1|| i-l+1>k){
                freq[s.charAt(l++)-'a']--;
            }
            total+= i-l+1==k?1:0;
        }
        return total;
    }
    public static void main(String[] args) {
        String s="haeertfunnonleetcode";
        int k=5;
        System.out.println(getSubStringCountWithLengthK(s,k));
        System.out.println(getSubStringCountWithLengthKUseSlidingWindow(s,k));

    }
}
