package leetcode.string;

public class TypedOutString {

    public static boolean isTypedEquals(String s1, String s2) {
        if (s1.equals(s2)) return true;
        return getFormatedString(s1).equals(getFormatedString(s2));


    }

    public static boolean isEqual(String s1, String s2) {
        //abc#d
        //abzz##d
        //"x#y#z#",
        // "a#"
        int len1 = s1.length(), len2 = s2.length();
        int l = len1 - 1;
        int r = len2 - 1;
        while (l >= 0 || r >= 0) {
            if (l > -1 && r > -1 && s1.charAt(l) != '#' && s2.charAt(r) != '#') {
                if (s1.charAt(l) != s2.charAt(r)) {
                    return false;
                }
                l--;
                r--;
                continue;
            }
            int countHash1 = 0;
            while (l > -1 && s1.charAt(l) == '#') {
                l--;
                countHash1++;
            }
            int countHash2 = 0;
            while (r > -1 && s2.charAt(r) == '#') {
                r--;
                countHash2++;
            }
            if (countHash1 > 0) {
                l = l - countHash1 > -1 ? l - countHash1 : -1;
            }
            if (countHash2 > 0) {
                r = r - countHash2 > -1 ? r - countHash2 : -1;
            }

        }
        return true;
    }

    public static String getFormatedString(String s) {
        int p = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '#' && p > 0) {
                sb.deleteCharAt(--p);
            } else if(c!='#') {
                sb.append(c);
                p++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "ab#z";
        String s2 = "az#z";
        System.out.println(isTypedEquals("y#fo##f", "y#f#o##f")); //true
        System.out.println(isTypedEquals("abc#d", "acc#c")); //false
        System.out.println(isTypedEquals("x#y#z#", "a#")); //true
        System.out.println(isTypedEquals("a###b", "b")); //true
        System.out.println("dddddddddddddd");
        System.out.println(isEqual("bxj##tw", "bxo#j##tw")); //true
        System.out.println(isEqual("abc#d", "acc#c")); //false
        System.out.println(isEqual("x#y#z#", "a#")); //true
        System.out.println(isEqual("a###b", "b")); //true

    }
}
