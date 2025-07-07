package leetcode.string;

import dsa.mustafaSaad.designpatteren.observer.Main;

public class StringCompression {
    public static int compress(char[] chars) {
        if(chars.length==1)return 1;
        StringBuilder sb=new StringBuilder();
        int count=0;
        char prev=chars[0];
        for(char c:chars){
            if(prev==c){
                count++;
                continue;
            }
            sb.append(prev);
            if(count>1)
                sb.append(count);
            prev=c;
            count=1;
        }
        sb.append(prev);
        if(count>1)
            sb.append(count);
        String s=sb.toString();
        for(int i=0;i<s.length();i++){
            chars[i]=s.charAt(i);
        }
        return sb.length();
    }

    public static void main(String[] args) {
        char[]c={'a','a','b','b','c','c','c'};
        System.out.println(compress(c));
    }
}
