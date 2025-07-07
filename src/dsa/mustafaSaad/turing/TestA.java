package dsa.mustafaSaad.turing;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestA {
    public boolean isArmstrong(int n) {
        String s = String.valueOf(n);
        int len = s.length();
        int sum = s.chars().map(ch -> Character.digit(ch, 10))
                .map((digit) -> (int) Math.pow(digit, len)).sum();
        return sum == n;
    }

    public boolean isPrime(int n) {
        if (n < 1) return false;
        if (n == 2) return true;
        return IntStream.rangeClosed(2, (int) Math.sqrt(n)).noneMatch(x -> n % x == 0);
    }

    public static void InStreamUSe() {
        int x = 0;
        // generate
        IntSupplier sup = () -> 2;
        IntUnaryOperator un = (s) -> s + 2;
        IntStream.generate(sup).limit(5).forEach(System.out::println);
        System.out.println("Int iterate");
        IntStream.iterate(1, un).limit(5).forEach(System.out::println);
    }

    static int findDuplicates(int[] a) {
        Map<Integer, Long> map = Arrays.stream(a).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int dup = map.keySet().stream().filter(k -> map.get(k) > 1).findFirst().orElse(0);
// print all dup
        map.keySet().stream().filter(k -> map.get(k) > 1).forEach(System.out::println);
        return dup;
    }

    static boolean isPlandrom(String s) {
        int len = s.length();
        System.out.println("len/2:" + len / 2);
        boolean isPland = IntStream.range(0, len / 2)
                .allMatch(index -> {
                    System.out.println(" index: " + index + ", char:" + s.charAt(index));
                    return s.charAt(index) == s.charAt(len - index - 1);
                });
        return isPland;
    }

    static void printDuplicates(String s) {
        int len = s.length();
        Map<Character, Long> map = IntStream.range(0, len)
                .mapToObj(i -> Character.toUpperCase(s.charAt(i)))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        map.entrySet()
                .stream().filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);
    }

    static void Fabonaci() {
        Stream.iterate(new int[]{0, 1}, f -> {
            return new int[]{f[1], f[0] + f[1]};
        }).limit(10).map(f -> f[0]).forEach(System.out::println);
    }

    public static void FindMinAndMaxInArray(int[] a) {
        int max = Arrays.stream(a).boxed().max(Integer::compareTo).get();
        int min = Arrays.stream(a).boxed().min(Integer::compareTo).get();
        int min2 = Arrays.stream(a)
                .reduce((x, y) -> x < y ? x : y).orElse(0);
        int max2 = Arrays.stream(a)
                .reduce((x, y) -> x > y ? x : y).orElse(0);
        System.out.println("min:" + min);
        System.out.println("max:" + max);

        System.out.println("min:" + min2);
        System.out.println("max:" + max2);
    }

    private static void SecondHighestFinder(int[] a) {

        int[] t = Arrays.stream(a)
                .distinct().boxed()
                .reduce(new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE}, (acc, num) -> {
                    if (num > acc[0]) {
                        acc[1] = acc[0];
                        acc[0] = num;
                    } else if (num > acc[1] && num != acc[0]) {
                        acc[1] = num;
                    }
                    return acc;
                }, (acc1, acc2) -> acc1[0] > acc2[0] ? acc1 : acc2);
    }

    static String getLongestStringInArray(String[] a) {
        return Arrays.stream(a).reduce((w1, w2) -> w1.length() > w2.length() ? w1 : w2).orElse("");
    }

    static String generateShortestPalindrome(String prefix) {
        if(prefix==null) return null;

        StringBuilder fPart = new StringBuilder();
        int l = 0, r = prefix.length() - 1;
        while (l < r) {
            char lc = prefix.charAt(l);
            char rc = prefix.charAt(r);
            fPart.append(lc);
            if (lc == rc) {
                r--;
            }
            l++;
        }

        String res = fPart.toString();
        if (l == r) {
            return res + prefix.charAt(l) + fPart.reverse();
        }
        return res + fPart.reverse();
    }

    static String getFirstRepeat(String s) {
        String[] chars = s.split("");
        Map<String, Long> map = Stream.of(chars).collect(Collectors.groupingBy(a -> a, LinkedHashMap::new,
                Collectors.counting()));
        String res = map.entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey)
                .findFirst().get();
        return res;
    }

    public int[] sweetAndSavory(int[] dishes, int target) {
        // Write your code here.
        int[] res = new int[2];
        Arrays.sort(dishes);
        int l = 0, r = dishes.length - 1;
        if (dishes.length == 0 || dishes[0] > 0 || dishes[r] < 0) return res;
        int val = target;
        while (l < r) {
            int sum = dishes[r] + dishes[l];
            if (sum > target) {
                r--;
            } else if (sum == target) {
                return new int[]{dishes[l], dishes[r]};
            } else {
                int cDiff = target - sum;
                if (val > cDiff) {
                    val = cDiff;
                    res[0] = dishes[l];
                    res[1] = dishes[r];
                }
                l++;
            }
        }
        return res;
    }

    public static int minInsertions(String prefix) {
        int l = 0, r = prefix.length() - 1;
        int count=0;
        while (l < r) {
            char lc = prefix.charAt(l);
            char rc = prefix.charAt(r);
            if (lc == rc) {
                r--;
            }
            else{
                count++;
            }
            l++;
        }
        return count;
    }

    public static void main(String[] args) {
        int a[] = {1, 4, 5, 2, 12, 34, 34, 11, 4, 5};
        //cba
        //  abcba// != cbabc
        //  abcdbdcba
        String s="bacba"; // bacb
//        System.out.println( generateShortestPalindrome("a").equals("a"));
//        System.out.println( generateShortestPalindrome("ab").equals("aba"));
//        System.out.println( generateShortestPalindrome("abb").equals("abba"));
//        System.out.println( generateShortestPalindrome("race").equals("racecar"));
//        System.out.println( generateShortestPalindrome("racec").equals("racecar"));
//        System.out.println( generateShortestPalindrome("raceca").equals("racecar")); //r aceca  r
//        System.out.println( generateShortestPalindrome("racecar").equals("racecar"));
//        System.out.println( generateShortestPalindrome("racecec").equals("racececar"));
//        System.out.println( generateShortestPalindrome("racecab").equals("racecabacecar"));
//        System.out.println( generateShortestPalindrome("abcbc").equals("abcbcba"));
        System.out.println( generateShortestPalindrome("abacb").equals("abacbcaba")); //abacbaa
//        System.out.println( generateShortestPalindrome("").equals(""));
//        System.out.println( generateShortestPalindrome("  ").equals("  "));
//        System.out.println( generateShortestPalindrome(null) == null);
    }
}
