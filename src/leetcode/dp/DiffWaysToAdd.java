package leetcode.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiffWaysToAdd {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        if (expression.length() <= 1) {
            res.add(Integer.valueOf(expression));
            return res;
        }
        if (expression.length() == 2 && Character.isDigit(expression.charAt(0))) {
            res.add(Integer.valueOf(expression));
            return res;
        }
        for (int i = 0; i < expression.length(); ++i) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) continue;
            List<Integer> left = diffWaysToCompute(expression.substring(0, i));
            List<Integer> right = diffWaysToCompute(expression.substring(i + 1));

            for (int lVal : left) {
                for (int rVal : right) {
                    int total = lVal;
                    switch (c) {
                        case '+':
                            total += rVal;
                            break;
                        case '-':
                            total -= rVal;
                            break;
                        case '*':
                            total *= rVal;
                            break;
                    }
                    res.add(total);
                }
            }
        }
        return res;
    }

    private List<Integer> diffWaysToCompute(String expression, int start, int end, Map<String, List<Integer>> memo) {
        List<Integer> res = new ArrayList<>();
        int n = expression.length() - 1;
        String key = start + "," + end;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        // one char
        if (start == end || (end - start == 1 && Character.isDigit(expression.charAt(start)))) {
            String s = expression.substring(start, end + 1);
            res.add(Integer.valueOf(s));
            return res;
        }

        for (int i = start; i <= end; ++i) {
            // loop until get operation
            char c = expression.charAt(i);
            if (Character.isDigit(c)) continue;

            List<Integer> left = diffWaysToCompute(expression, start, i - 1, memo);
            List<Integer> right = diffWaysToCompute(expression, i + 1, end, memo);

            for (int lVal : left) {
                for (int rVal : right) {
                    int total = lVal;
                    switch (c) {
                        case '+':
                            total += rVal;
                            break;
                        case '-':
                            total -= rVal;
                            break;
                        case '*':
                            total *= rVal;
                            break;
                    }
                    res.add(total);
                }
            }
        }
        memo.put(key, res);
        return res;
    }

    public char[] minimumCharactersForWords(String[] words) {
        // Write your code here.
        List<Character> res = new ArrayList();
        Map<Character, Integer> map = new HashMap();
        for (String word : words) {
            calcWordChar(word, map);
        }
        return new char[]{};
    }

    public static void calcWordChar(String word, Map<Character, Integer> map) {
        Map<Character, Integer> wordMap = new HashMap();
        for (char c : word.toCharArray()) {
            wordMap.merge(c, 1, Integer::sum);
        }
        for (char key : wordMap.keySet()) {
            int count = wordMap.get(key);
            int prevCount = map.getOrDefault(key, 0);
            map.put(key, count + prevCount);
        }
    }

}
