package dsa.mustafaSaad.thread;
import java.util.*;

public class Counter {
    public static class SNClass{

    }
    private int count=0;
    private Object mutex=new Object();


    public void increment(){
        synchronized (mutex){
            try {
                this.count++;
                System.out.println(Thread.currentThread().getName()+ " thread increment count to: "+count);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void decrement(){
        synchronized (mutex){
            try {
                this.count--;
                System.out.println(Thread.currentThread().getName()+ " thread decrement count to: "+count);

                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public int getCount(){
        synchronized (mutex){
            return count;
        }
    }

    public static void main(String[] args) {
        List<Integer> list=Arrays.asList(1,2,3);
        Integer[] a=list.toArray(new Integer[0]);
        Arrays.stream(a).forEach(System.out::println);
        SNClass cd=new Counter.SNClass();
        final Integer x;
        final int y;
        y=90;
        x=Integer.valueOf(5);
        Counter c=new Counter();
        Runnable r1=()->{
            for(int i=0;i<10;i++){
                c.increment();
            }
        };
        Runnable r2=()->{
            for(int i=0;i<10;i++){
                c.decrement();
            }
        };

        Thread t1=new Thread(r1,"T1");
        Thread t2=new Thread(r2,"T2");

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();

            System.out.println(Thread.currentThread().getName()+ " thread getting count value:"+c.count);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
