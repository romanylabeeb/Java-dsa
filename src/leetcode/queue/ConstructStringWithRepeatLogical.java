package leetcode.queue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ConstructStringWithRepeatLogical {
    public static String repeatLimitedString2(String s, int k) {
        int[] a = new int[26];
        for (char c : s.toCharArray()) {
            a[c - 'a']++;
        }
        boolean has = true;
        StringBuilder sb = new StringBuilder();
        while (has) {
            has = false;

            for (int i = 25; i >= 0; --i) {
                int rep = a[i];
                if (rep == 0) {
                    continue;
                }
                char c = (char) (i + 'a');
                int count = rep < k ? rep : k;
                if (!sb.isEmpty() && sb.charAt(sb.length() - 1) == c) {
                    continue;
                }
                while (count > 0) {
                    sb.append(c);
                    count--;
                }
                has = true;
                a[i] = rep > k ? rep - k : 0;
                if (a[i] > 0) {
                    for (int j = i - 1; j >= 0; --j) {
                        if (a[j] > 0) {
                            char cb = (char) (j + 'a');
                            sb.append(cb);
                            a[j]--;
                            break;
                        }
                    }
                    i++;
                }
            }
        }
        return sb.toString();
    }

    public long pickGifts(int[] gifts, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(b[0], a[0]);
        });
        for (int i = 0; i < gifts.length; ++i) {
            pq.offer(new int[]{gifts[i], i});
        }

        while (k > 0) {
            int[] gift = pq.poll();
            int index = gift[1];
            gift[0] = getRootSquare(gift[0]);
            gifts[index] = gift[0];
            pq.offer(gift);
            k--;
        }
        long count = 0;
        for (int v : gifts) {
            count += v;
        }
        return count;
    }

    int getRootSquare(int v) {
        return (int) Math.floor(Math.sqrt(v));
    }


}
