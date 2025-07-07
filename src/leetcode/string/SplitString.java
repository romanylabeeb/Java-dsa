package leetcode.string;

import java.util.HashSet;
import java.util.Set;

public class SplitString {
    public static int maxUniqueSplit(String s) {
        Set<String> set=new HashSet<>();
        StringBuilder temp=new StringBuilder();
        for(char c:s.toCharArray()){
            if(!temp.isEmpty()){
                temp.append(c);
                if(!set.contains(temp.toString())){
                    set.add(temp.toString());
                    temp.setLength(0);
                }
            }
            else if(set.contains(String.valueOf(c))){
                temp.append(c);
            }
            else {
                set.add(String.valueOf(c));
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(maxUniqueSplit("wwwzfvedwfvhsww"));
    }
}
