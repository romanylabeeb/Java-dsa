package dsa.mustafaSaad.thread;

import java.util.concurrent.*;
class MyCallable implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        Thread.sleep(2000);
        return 33;
    }
}
public class CallableFutureExample {
    public static void main(String[] args) {
        MyCallable task=new MyCallable();
        FutureTask<Integer> futureTask=new FutureTask<>(task);
        Thread t1=new Thread(futureTask,"ftask");
        t1.start();
        try{
            Integer v=futureTask.get();
            System.out.println("v:"+v);
        }
        catch (InterruptedException|ExecutionException e){
            throw new RuntimeException(e);
        }
        ExecutorService executorService=Executors.newFixedThreadPool(5);
        Future<Integer> future=executorService.submit(task);
            try {
                Integer res=future.get();
                System.out.println(res);
            } catch (InterruptedException |ExecutionException e) {
                throw new RuntimeException(e);
            }
            finally {
                executorService.shutdown();
        }
    }
}