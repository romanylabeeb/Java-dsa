package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class StringParentheses {

    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0) return false;
        int n = s.length();
        Deque<Character> stk = new ArrayDeque<>();
        int countStar = 0;
        int countClose=0;
        int countOpen=0;
        for (int i = 0; i < n; ++i) {
            boolean isLocked = locked.charAt(i) == '1';
            char current = s.charAt(i);
            if (!isLocked) {
                current='*';
                countStar++;
            } else {
                if(current==')'){
                    ++countClose;
                }
                else{
                    countOpen++;
                }
            }
            stk.offerLast(current);
            if((stk.size()/2)< countClose) return false;

        }
        int blockCount = stk.size() - countStar;
        if (stk.size() % 2 != 0 || blockCount > countStar) return false;
        if (!stk.isEmpty() && (stk.peekLast() == '(' || stk.peekFirst() == ')')) return false;
        return true;
    }

    public static void main(String[] args) {
        String s = "))()))";
        String blocked = "010100";
        StringParentheses obj = new StringParentheses();
        System.out.println(obj.canBeValid(s, blocked));
    }
}
