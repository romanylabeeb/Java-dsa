package leetcode.twopointers;

public class MinRecolrK {
    public static int minimumRecolors(String blocks, int k) {

        int n=blocks.length();
        if(k>n)return 0;
        int lp=0;
        int w=0;
        int res=0;
        for(int i=0;i<k;++i){
            if(blocks.charAt(i)=='W'){
                w++;
            }
        }
        res=w;

        for(int i=k;i<n;++i){
            if(blocks.charAt(lp++)=='W'){
                w--;
            }
            if(blocks.charAt(i)=='W'){
                w++;
            }
            res=Math.min(res,w);
        }
        return res;
    }

    public static void main(String[] args) {
        int k=2;
        String blocks="WBWBBBW";
        System.out.println(minimumRecolors(blocks,k));
    }
}
