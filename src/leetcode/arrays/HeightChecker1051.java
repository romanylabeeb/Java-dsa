package leetcode.arrays;

import java.util.Arrays;

public class HeightChecker1051 {
    /**
     * https://leetcode.com/problems/height-checker/
     *
     * @param heights
     * @return
     */
    public int heightChecker(int[] heights) {
        // limits height=100
        int[] count = new int[101];
        // count each height
        for (int v : heights) {
            count[v]++;
        }
        int res = 0;
        int i = 0;
        for(int j = 0; j < 101; j++){
            int c = count[j];
            while(c > 0){
                if(heights[i] != j){
                    res++;
                }
                i++;
                c--;
            }
        }

        return res;
    }
    public int heightChecker2(int[] heights) {
        int[] sortedHeights = heights.clone();
        Arrays.sort(sortedHeights);

        // Count the number of positions where the elements differ
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != sortedHeights[i]) {
                count++;
            }
        }

        return count;
    }
}
