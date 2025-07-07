package dsa.mustafaSaad.thread;

class UserThread implements Runnable {

    public void run() {
        try {
            long time = System.currentTimeMillis();
            System.out.println("Starting execution " + Thread.currentThread().getName() + " thread, on :" + time);
            Thread.sleep(1000);
            for(int i=0;i<10;i++){
                System.out.println(Thread.currentThread().getName()+" thread, i="+ i);
                Thread.sleep(500);

            }
            long endtime = System.currentTimeMillis();

            System.out.println("Finished execution " + Thread.currentThread().getName() + " thread, on :" + endtime);

            System.out.println("total time:" + Thread.currentThread().getName() + " thread =" + (endtime - time));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class MainThread {
    public static void main(String[] args) {
        try {
            long time = System.currentTimeMillis();

            Thread t1 = new Thread(new UserThread(), "T1");
            Thread t2 = new Thread(new UserThread(), "T2");
            System.out.println("Starting execution " + Thread.currentThread().getName() + " thread, on :" + time);
            t1.start();

            t2.start();
            t1.join(); // make main thread wait t1 until finish
            t2.join(300); // make main thread wait t2 for 200
            long endtime = System.currentTimeMillis();
            System.out.println("Finished execution " + Thread.currentThread().getName() + " thread, on :" + endtime);
            System.out.println("total time:" + Thread.currentThread().getName() + " thread =" + (endtime - time));

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
