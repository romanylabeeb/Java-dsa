package leetcode.linkedList;

import java.util.*;
import java.util.stream.Collectors;

public class TestCollection {
    static void remove() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("B");
//        for(int i=0;i<list.size();i++){
//
//        }
//
//        for (String s : list) {
//            if ("B".equals(s)) {
//                list.remove(s);
//            }
//        }

        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            String element = iterator.next();
            if ("B".equals(element)) {
                iterator.remove();
            }
        }

        list.forEach(System.out::println);

    }

    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap();
        toggleWord(s1, map);
        toggleWord(s2, map);
        List<String> uncom = new ArrayList();
        for (String key : map.keySet()) {
            if (map.get(key) == 1) {
                uncom.add(key);
            }
        }
        return uncom.stream().toArray(String[]::new);
    }

    void toggleWord(String str, Map<String, Integer> map) {
        String[] l = str.split(" ");
        for (String w : l) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
    }

    public static void main(String[] args) {
        String s1 = "pales";
        String s2 = "palesd";
        System.out.println(isValid(s1, s2));
    }

    static boolean isValid(String s1, String s2) {
        if (Math.abs(s1.length() - s2.length()) > 1) return false;
        //
        int p1 = 0, p2 = 0;
        boolean foundDif = false;
        String small = s1.length() <= s2.length() ? s1 : s2;
        String tall = s2.length() >= s1.length() ? s2 : s1;
        while (p1 < small.length() && p2 < tall.length()) {
            if (small.charAt(p1) != tall.charAt(p2)) {
                if (foundDif) return false;
                foundDif = true;
                // replace
                if (small.length() != tall.length()) {
                    p2++;
                }
                else {
                    p1++;
                    p2++;
                }
            } else {
                p1++;
                p2++;
            }
        }
        return true;

    }
}
