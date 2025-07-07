package leetcode.arrays;

public class NumberOfWays2270 {
    public static int waysToSplitArray(int[] nums) {
        int n=nums.length;
        int count=0;
        long []sum=new long[n];
        long total=0;
        for(int i=0;i<n;++i){
            total+=nums[i];
            sum[i]=total;
        }
        for(int i=0;i<n-1;++i){
            if(sum[i]>=(total-sum[i])){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int []a={6,-1,9};
        System.out.println(waysToSplitArray(a));
    }
}
