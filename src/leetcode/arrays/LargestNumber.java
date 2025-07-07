package leetcode.arrays;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/largest-number/
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        String conc = Arrays.stream(nums).boxed()
                .map(v -> String.valueOf(v))
                .sorted(Comparator.comparing(String::toString, (a, b) -> (a + b).compareTo(b + a)))
                .collect(Collectors.joining());
        return conc.startsWith("0") ? "0" : conc;
    }

    public static String largestNumber2(int[] nums) {
        List<String> a = Arrays.stream(nums).boxed().map(v -> String.valueOf(v)).collect(Collectors.toList());
        Comparator<String> comparator = (x, y) -> (y + x).compareTo(x + y);
        a.sort(comparator);
        if (a.size() == 0 || a.get(0).equals("0")) {
            return "0";
        }
        return String.join("", a);
    }

    public String frequencySort(String s) {
        Comparator<Map.Entry<String, Long>> comp = Comparator.comparing(Map.Entry<String, Long>::getValue).reversed();
        String res = Stream.of(s.split("")).collect(Collectors.groupingBy(a -> a, Collectors.counting()))
                .entrySet().stream().sorted(comp)
                .map(entry -> entry.getKey().repeat(entry.getValue().intValue())).collect(Collectors.joining());
        return res;
    }

    //https://leetcode.com/problems/sort-characters-by-frequency/submissions/
    public String frequencySort2(String s) {
        // Create a frequency map
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Create a priority queue that sorts characters by their frequency in descending order
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue()
        );

        // Add all entries of the frequency map to the priority queue
        maxHeap.addAll(frequencyMap.entrySet());

        // Build the result string by polling from the priority queue
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                result.append(entry.getKey());
            }
        }

        return result.toString();
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        Set<String> banSet = new HashSet<>(Arrays.asList(banned));
        String[] a = paragraph.replaceAll("[!?',;.]", " ").toLowerCase().split(" ");
            Map<String,Integer>countMap=new HashMap<>();
            String res="";
            int maxOcur=0;
            for(String s:a){
                if(banSet.contains(s)) continue;;
                int count=countMap.getOrDefault(s,0);
                countMap.put(s,count+1);
                if(maxOcur< count+1){
                    res=s;
                    maxOcur=count+1;
                }
            }
            return res;
//        return Arrays.stream(a)
//                .filter(w -> w.trim().length() > 0)
//                .filter(w -> !banSet.contains(w))
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet()
//                .stream()
//                .max(Map.Entry.comparingByValue()).get().getKey();

    }

    public static void main(String[] args) {
        int[] nums = {0, 0};
        largestNumber2(nums);
        String p=    "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[]b={"hit"};
        System.out.println(mostCommonWord(p,b));

    }
}
