package leetcode.mathp;

import java.util.Map;

public class MinAdd {


    public long makeIntegerBeautiful(long n, int target) {
        int add = 0;
        double ten=1;
        while(sumNumber(n)>target){
            int base= (int)Math.pow(10,ten);
            long re=(n/(base/10))%10;
            int adding=(base)-(int)(re*(base/10));
            add+=adding;
            n+=adding;
            ten++;
        }
        return add;
    }

    int sumNumber(long n) {
        int sum = 0;
        while (n > 10) {
            sum += n % 10;
            n /= 10;
        }
        sum+=n;
        byte []c=new byte[3];
        return sum;
    }

     public static void main(String[] args) {
        MinAdd minAdd=new MinAdd();
         System.out.println( minAdd.makeIntegerBeautiful(8,2));
    }
}
