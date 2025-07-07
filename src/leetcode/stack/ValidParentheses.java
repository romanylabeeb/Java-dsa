package leetcode.stack;

import java.util.*;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid2(String s) {
        char[] stk = new char[s.length()];
        int top = -1;
        for (char c : s.toCharArray()) {
            switch (c) {
                case '{':
                case '(':
                case '[':
                    stk[++top] = c;
                    break;
                default:
                    if (!validateStack(stk, c, top)) {
                        return false;
                    }
                    top--;
                    break;

            }
        }
        return top == -1;
    }

    private boolean validateStack(char[] stk, char rightP, int top) {
        if (top == -1)
            return false;
        char leftP = stk[top];
        switch (rightP) {
            case '}':
                return leftP == '{';
            case ']':
                return leftP == '[';
            default:
                return leftP == '(';
        }
    }

    public boolean isValid(String s) {
        Stack<Character> stk = new Stack();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '{':
                case '(':
                case '[':
                    stk.push(c);
                    break;
                default:
                    if (!validateStack(stk, c)) {
                        return false;
                    }
                    break;

            }
        }
        return stk.isEmpty();
    }

    private boolean validateStack(Stack<Character> stk, char rightP) {
        char leftP = stk.pop();
        return !stk.isEmpty() && ((leftP == '{' && rightP == '}') || (leftP == '[' && rightP == ']') || (leftP == '(' && rightP == ')'));
    }

    public static void main(String[] args) {
        ValidParentheses v = new ValidParentheses();
        System.out.println(v.isValid("({[)]})[]{}}"));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        int[] smallArray = nums1.length < nums2.length ? nums1 : nums2;
        Map<Integer, Integer> map = new HashMap<>();

        for (int v : smallArray) {
            int count = map.getOrDefault(v, 0);
            map.put(v, count + 1);
        }
        List<Integer> res = new ArrayList<>();
        int[] large = smallArray.equals(nums2) ? nums1 : nums2;
        for (int v : large) {
            int count = map.getOrDefault(v, -1);
            if (count >= 1) {
                res.add(v);
                if (count == 1) {
                    map.remove(v);
                } else {
                    map.put(v, count - 1);
                }
            }
        }
        int[] array = res.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        int y= res.stream().reduce(0,Integer::sum);
        return array;
    }
}
