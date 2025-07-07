package dsa.mustafaSaad.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTesting {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> n1 = new HashSet();
        for (int v : nums1) {
            n1.add(v);
        }
        return Arrays.stream(nums2).distinct().filter(v -> n1.contains(v)).toArray();
    }

    static void convertStreamToArray() {
        int[] a = {1, 2, 3, 4, 5};
        String[] re = Arrays.stream(a).mapToObj(String::valueOf).toArray(String[]::new);
        for (String s : re) {
            System.out.println(s);
        }
    }

    static void mutliTransform() {
        int[] a = {3, 4, 5, 6};

    }

    public static void getFrequenlty(String s) {
        Map<Character, Long> res = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (Map.Entry<Character, Long> entry : res.entrySet()) {
            System.out.println(String.format("%s: %d", entry.getKey(), entry.getValue()));
        }
    }

    static int findSecondLargest(int[] a) {
        int r = Arrays.stream(a).boxed()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .skip(1).
                findFirst().
                get();
        return r;
    }

    public void removeDuplicates(int[] a) {
        int[] res = Arrays.stream(a)
                .distinct().toArray();
    }

    public static long sumDigits(int x) {
        long res = String.valueOf(x).chars().map(Character::getNumericValue).sum();
        return res;
    }

    public static String retrievLastElement(String[] a) {
        return Arrays.stream(a).skip(a.length - 1).findFirst().get();
    }

    public static void reverseEachWord(String s) {
        String g = Arrays.stream(s.split(" ")).map(w -> new StringBuilder(w).reverse()).collect(Collectors.joining(" "));
        System.out.println(g);
    }

    static public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int next = n;
        while (!set.contains(next) && next != 1) {
            set.add(next);
            next = String.valueOf(next).chars().map(Character::getNumericValue).map(v -> v * v).sum();
        }
        return next == 1;
    }

    public boolean isHappyUsingFastSlow(int n) {
//        1. Floyd’s Cycle-Finding Algorithm (Tortoise and Hare)

        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    int getNext(int n) {
        return String.valueOf(n).chars().map(Character::getNumericValue).map(v -> v * v).sum();
    }


    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        Set<Character> used = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            char rep = s.charAt(i);
            char c = t.charAt(i);
            Character rep2 = map.get(rep);
            if (rep2 == null) {
                map.put(rep, c);
            } else if (rep2 != c) {
                return false;
            }
            sb.append(rep);
            //foo
            //  bar
        }
        return s.equals(sb.toString());

    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = IntStream.range(0, list1.length)
                .boxed()
                .collect(Collectors.toMap(i -> list1[i], i -> i));
        Map<Integer, ArrayList<String>> res = new HashMap<>();
        for (int i = 0; i < list2.length; i++) {
            String w = list2[i];
            if (map.containsKey(w)) {
                int sumIndex = map.get(w) + i;
                res.computeIfAbsent(sumIndex, k -> new ArrayList<>());
                res.get(sumIndex).add(w);
            }

        }
        int minKey = res.keySet().stream().min(Integer::compare).orElseThrow();
        return res.get(minKey).toArray(new String[0]);
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        // Map to store the last seen index of each number
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if ((i - map.get(nums[i])) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public int chalkReplacer(int[] chalk, int k) {
        long sum = Arrays.stream(chalk).asLongStream().sum();
        int rem = (int) (k % sum);
        int i = 0;
        while (chalk[i] <= rem) {
            rem -= chalk[i++];
        }
        return i;
    }

    public static void passByValue(StringBuilder sb){
        sb=new StringBuilder("gt");
    }
    public static int getLucky(String s, int k) {
        StringBuilder sb=new StringBuilder();
        for(char c:s.toCharArray()){
            int v=c-'a'+1;
            sb.append(v);
        }
        for (int i = 0; i < k; i++) {
            String r = String.valueOf((sb.toString().chars()
                    .map(Character::getNumericValue)
                    .sum()));
            sb=new StringBuilder(r);

        }
        return Integer.valueOf(sb.toString());
    }

    // foo, bar
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder("hello");
        passByValue(sb);
        System.out.println(sb.toString());
        getLucky("iiia", 4);
        int[] s = {1, 0, 1, 1};
        System.out.println(containsNearbyDuplicate(s, 1));
        isIsomorphic("badc", "baba");
        convertStreamToArray();
        System.out.println(new ArrayList<>(55).size());
        getFrequenlty("asdcsasdes");
        int[] a = {54, 12, 34, 56, 76, 77, 123, 123, 12, 1, 2, 33, 2};
        System.out.println(findSecondLargest(a));
        System.out.println(sumDigits(34567));
        String[] data = {"tea", "df", "mag", "mug"};
        System.out.println(retrievLastElement(data));
        reverseEachWord("as df gh jk bn mmnnc");
        int[] b = {12, 3, 4, 6, 77, 1, 2};
        int[] res = intersection(a, b);
        System.out.println(res);
        System.out.println(isHappy(2));
    }
}
