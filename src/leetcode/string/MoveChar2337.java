package leetcode.string;

public class MoveChar2337 {
    public static boolean canChange(String start, String target) {
        int n1 = start.length();
        int n2 = target.length();

        if (n1 != n2) return false;
        int l1 = 0;
        int l2 = 0;
        char moved = '1';
        while (l1 < n1 && l2 < n2) {
            int c = moved != '1' ? moved : start.charAt(l1);
            int t = target.charAt(l2);
            if (c == t) {
                moved = '1';
                l1++;
                l2++;
            } else if (c == '_') {
                if (l1 + 1 < n1 && t == 'L' && start.charAt(l1 + 1) == t) {
                    moved = '_';
                    l1++;
                    l2++;
                } else {
                    return false;
                }
            } else if (c == 'R') {
                if (l1 + 1 < n1 && t == '_' && start.charAt(l1 + 1) == t) {
                    moved = 'R';
                    l1++;
                    l2++;
                } else {
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "_L__R__R_";
        String target = "L______RR";
        System.out.println(canChange(s1,target));
    }
}
