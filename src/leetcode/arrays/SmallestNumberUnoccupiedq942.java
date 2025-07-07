package leetcode.arrays;

import java.util.function.*;

public class SmallestNumberUnoccupiedq942 {

    public static int smallestChair(int[][] times, int target) {
        int[] dict = new int[target+1];
        int dest=0;
        for (int i = 0; i <= target; ++i) {
            dest= calc(times[i][1],dict);
        }
        return dest;
    }

    static int calc(int leave,int[]dict){
        int index=0;
        int result=-1;
        System.out.println(leave);
        for(int i=0;i<dict.length;++i){

            if(dict[i]!=0&&dict[i]==i){
                //reset
                dict[i]=0;
            }
            if(result==-1&&dict[i]==0){
                dict[i]=leave; //time[1];
                result=i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][]times={{3,10},{1,5},{2,6}};
        System.out.println(smallestChair(times,0));
        BiPredicate<Integer, Integer> sumGreaterThan100 = (a, b) -> (a + b) > 100;  sumGreaterThan100.test(59,60);
        BinaryOperator<String> binaryOperator=(s,b)-> s.concat(b);
        binaryOperator.apply("hello","world");
        UnaryOperator<String> unOper= s-> "hello"+s;  unOper.apply("Gouri");
        String name="MR Rom";
        BiPredicate<String,Integer> biPredicate=name::startsWith;
        biPredicate.test("mr",0);
        //
        BiFunction<String,String,String>biFunction=String::concat;
        // use first param to concat
        String res=biFunction.apply("hello","world");

    }
}
