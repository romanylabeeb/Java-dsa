package dsa.mustafaSaad.threading;


import java.util.concurrent.CyclicBarrier;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

class CountDownLatchExample {
    public static void main(String[] args) {
        final int count = 3;
        CountDownLatch latch = new CountDownLatch(count);

        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " performing task");
                Thread.sleep(1000); // Simulate task
                latch.countDown();
                System.out.println(Thread.currentThread().getName() + " finished task");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < count; i++) {
            new Thread(task).start();
        }

        try {
            latch.await(); // Main thread waits until latch count reaches zero
            System.out.println("All tasks are completed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


 class CyclicBarrierExample {
     private static volatile int flag = 0;
     public static void main(String[] args) {
        final int parties = 3;
        // will run once
        Runnable CarrierTask=()->{
            flag++;
            System.out.println("All parties arrived at barrier");
            System.out.println("flag:"+flag);
        };
        CyclicBarrier barrier = new CyclicBarrier(parties, CarrierTask);

        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " waiting at barrier");
                barrier.await();
                System.out.println(Thread.currentThread().getName() + " crossed the barrier");
                System.out.println(Thread.currentThread().getName() +"flag:"+flag);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < parties; i++) {
            new Thread(task,"thread "+i).start();
        }
    }
}

public class CyclicBarrierTest {
}


 class RaceConditionSolution {
    private int counter = 0;
    private final Object lock = new Object();

    public static void main(String[] args) {
        RaceConditionSolution example = new RaceConditionSolution();
        example.startThreads();
    }

    private void startThreads() {
        Thread t1 = new Thread(this::incrementCounter);
        Thread t2 = new Thread(this::incrementCounter);

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void incrementCounter() {
        for (int i = 0; i < 10; i++) {
            synchronized (lock) {
                counter++;
                System.out.println(Thread.currentThread().getName()+"counter: "+counter);
            }
        }
        System.out.println("Counter: " + counter);
    }
}


 class VolatileExample {
    private static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        Thread writerThread = new Thread(() -> {
                flag = true;
                System.out.println("WriterThread set flag to true");

        });

        Thread readerThread = new Thread(() -> {
            while (!flag) {
                // Busy-wait until flag becomes true
            }
            System.out.println("ReaderThread detected flag change");
        });

        writerThread.start();
        readerThread.start();

        writerThread.join();
        readerThread.join();
    }
}

 class VolatileExample2 {
    private static volatile int counter = 0;
static AtomicInteger c=new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        Runnable r=()->{
            for (int i = 0; i < 10; i++) {
                c.incrementAndGet();
                System.out.println(Thread.currentThread().getName()+", counter= "+c);
            }
        };
        Thread t1 = new Thread(r);

        Thread t2 = new Thread(r);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Volatile Counter: " + counter); // May not print 2000 due to race condition
    }
}