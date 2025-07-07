package dsa.mustafaSaad.bootcamp;

public class ValidParentheses {
    /**
     * https://leetcode.com/problems/valid-parentheses/description/
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        //use stack or use arry and top pointer
        char[] stk = new char[s.length()];
        int top = -1;
        for (char c : s.toCharArray()) {
            switch (c) {
                case '{':
                case '(':
                case '[':
                    //append to my stck
                    stk[++top] = c;
                    break;
                default:
                    if (top<0||!isValidCLose(stk[top], c)) {
                        return false;
                    }
                    top--;
            }
        }
        return top==-1;
    }

    private boolean isValidCLose(char openBracket, char closeBracket) {
        switch (closeBracket) {
            case ')':
                return openBracket == '(';
            case ']':
                return openBracket == '[';
            default:
                return openBracket == '{';
        }
    }

    public static void main(String[] args) {
        String s="]";
        ValidParentheses v=new ValidParentheses();
        System.out.println(v.isValid(s));
    }
}
