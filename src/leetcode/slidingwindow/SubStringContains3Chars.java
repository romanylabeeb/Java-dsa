package leetcode.slidingwindow;

public class SubStringContains3Chars {

    public static int numberOfSubstrings(String s) {
        int rp=0;
        int n=s.length();
        int res=0;
        int []count=new int[3];
        for(int i=0;i<n-2;++i){
            if(i>0){
                count[s.charAt(i-1)-'a']--;
            }
            // check if count is valid
            while(!isValidMap(count)&&rp<n){
                count[s.charAt(rp++)-'a']++;
            }
            if(!isValidMap(count)){
                return res;
            }
            res+=n-rp+1;
        }
        return res;
    }
    public static boolean isValidMap(int []count){
        int total=0;
        for(int v:count){
            if(v>0){
                total++;
            }
        }
        return total>2;
    }

    public static void main(String[] args) {
        int x=numberOfSubstrings("abcabc");
        System.out.println(x);
    }
}
