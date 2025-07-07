package leetcode.arrays;

public class MaxChunk769 {
    public static int maxChunksToSorted(int[] arr) {
        int n=arr.length;
        int []a=new int[n];
        for(int i=0;i<n;++i){
            a[arr[i]]=i;
        }
        int count =1,l=0;
        while(l<n-1){
            int val=a[l];
            if(l==val){
                count ++;
                l++;
            }
            else{
                l=val;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int []a=new int[]{1,0,2,3,4};
        System.out.println(maxChunksToSorted(a));
    }
}
