package dsa.mustafaSaad.bootcamp;

import java.util.*;
import java.util.stream.IntStream;

public class TwoSum {
    /**https://leetcode.com/problems/two-sum/submissions/
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
     * Example 2:
     * <p>
     * Input: nums = [3,2,4], target = 6
     * Output: [1,2]
     * Example 3:
     * <p>
     * Input: nums = [3,3], target = 6
     * Output: [0,1]
     *
     * @param nums
     * @param t
     * @return
     */
    public int[] twoSum(int[] nums, int t) {
        // use map to keep track of remaining value key remaining value and value=index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int existintgIndex = map.getOrDefault(nums[i], -1);
            if (existintgIndex > -1) {
                return new int[]{existintgIndex, i};
            }
            int remainVal = t - nums[i];
            map.put(remainVal, i);
        }
        return new int[2];

        // usinh stream

    }
    public int[] twoSumUsingStream(int[] nums, int t) {
        // use map to keep track of remaining value key remaining value and value=index
        Map<Integer, Integer> map = new HashMap<>();
        Optional<int[]>optionalInts= IntStream.range(0,nums.length)
                .filter(i->{
                    int remainVal=t-nums[i];
                    if(map.containsKey(remainVal)){
                        return true;
                    }
                    map.put(nums[i],i);
                    return false;
                }).mapToObj(i->
                        new int[]{map.get(t-nums[i]),i})
                .findFirst();
        return optionalInts.orElseThrow(() -> new IllegalArgumentException("No two sum solution"));

    }
}
