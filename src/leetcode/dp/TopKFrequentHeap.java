package leetcode.dp;

import java.io.Serializable;
import java.util.*;

public class TopKFrequentHeap  implements Serializable {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> sum = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            sum.put(nums[i], sum.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer>[] count = new ArrayList[nums.length+1];
        ;//(nums.length);

        //
        for (Map.Entry<Integer, Integer> entry : sum.entrySet()) {
            if (count[entry.getValue()] == null) {
                count[entry.getValue()]= new ArrayList<>();
            }
            count[entry.getValue()].add(entry.getKey());
        }
        int counter = 0;
        int[] res = new int[k];
        for (int i = count.length - 1; i >= 0; i--) {
            List<Integer> row = count[i];
            if(row==null) continue;
            int rowIndex = 0;
            while (counter < k && rowIndex < row.size()) {
                res[counter++] = row.get(rowIndex++);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TopKFrequentHeap t=new TopKFrequentHeap();
        int[]a={1};
        int k=1;
        int []r=t.topKFrequent(a,k);
    }
}
