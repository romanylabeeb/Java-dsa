package leetcode.arrays;

public class LargeOutlier3371 {


    public static int getLargestOutlier(int[] nums) {
        int sum=0;
        // Arrays.sort(nums);
        for(int v:nums){sum+=v;}
        int lp=1;
        int prev=nums[0];
        int nxt= prev>0?(sum-prev): (sum+ -1*prev);

        while(lp<nums.length){
            int c=nums[lp];
            nxt-=c;
            if(lp==1 &&c==nxt) return nums[0];
            if(nxt==prev) return c;
            prev+= nums[lp++];

        }
        return nums[nums.length-1];
    }

    public static void main(String[] args) {
        int[]a={-906,-234,680,-672};
        System.out.println(getLargestOutlier(a));
    }
}
