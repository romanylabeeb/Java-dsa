package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String w : strs) {
            sb.append(w.length());
            sb.append('#');
            sb.append(w);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        int len = str.length();
        while (i < len) {
            int j=i;

            while(str.charAt(j)!='#'){
                j++;
            }
            int strLen = Integer.parseInt(str.substring(i,j));
            int startIndex = j + 1;
            res.add(str.substring(startIndex,startIndex+strLen));
            i = startIndex + strLen;
        }
        return res;
    }

    int getLength(String s, int index) {
        StringBuilder sb = new StringBuilder();

        for (int i = index; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                break;
            }
        }
        return Integer.parseInt(sb.toString());
    }

    String decodeStr(String s, int start, int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < start + len; ++i) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        EncodeDecode encodeDecode=new EncodeDecode();
        List<String>s=List.of("we","say",":","yes");
        String decode=encodeDecode.encode(s);
        System.out.println(decode);
        List<String> re=encodeDecode.decode(decode);
        System.out.println(re);
    }
}
