package leetcode.string;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 */
public class FirstUnique {
public static int firstUniqChar(String s) {

    int []chars=new int[26];
for(int i=0;i<26;i++){chars[i]=-1;}
    for(int i=0;i<s.length();i++){
        int index=s.charAt(i) -'a';
        if(chars[index]==-1){
            chars[index]=i;
        }
        else{
            chars[index]=-2;
        }
    }
    int res=-1;
    for(int i=0;i<26;i++){
        int index=chars[i];
        if(index>=0) {
            res=res!=-1?Math.min(res,index):index;
        }
    }
    return res;
}

    public static void main(String[] args) {
        int r=firstUniqChar("leetcode");
    }
}
