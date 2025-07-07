package dsa.mustafaSaad.bootcamp;

public class MajorityElement {
    /**
     * https://leetcode.com/problems/majority-element/
     *
     * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [3,2,3]
     * Output: 3
     * Example 2:
     *
     * Input: nums = [2,2,1,1,1,2,2]
     * Output: 2
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
    //using hashmap
        int cadidate=0;
        int count=0;
        for(int v:nums){
            if(count==0){
                cadidate=v;
            }
            if(cadidate==v){
                count++;
            }
            else {
                count--;
            }
        }
        return cadidate;
    }
}
