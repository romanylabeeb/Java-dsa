package dsa.mustafaSaad.bootcamp;

import java.util.*;

public class IntersectTwoArrays {
    /**
     * https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int v : nums1) {
            map.merge(v, 1, Integer::sum);
        }
        List<Integer> list = new ArrayList<>();
        for (int v : nums2) {
            if (map.getOrDefault(v,0)>0) {
                list.add(v);
                map.merge(v, -1, Integer::sum);
            }
        }
        int[] a = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        return a;
    }
}
