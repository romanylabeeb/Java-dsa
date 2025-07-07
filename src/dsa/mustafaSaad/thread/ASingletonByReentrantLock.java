package dsa.mustafaSaad.thread;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

public class ASingletonByReentrantLock {
    private static volatile ASingletonByReentrantLock instance;
    private static ReentrantLock lock = new ReentrantLock();// for sync

    private ASingletonByReentrantLock() {
    }

    public static ASingletonByReentrantLock getInstance() {
        if (instance == null) {
            try {
                // first acquire lock
                lock.lock();
                // double check
                if (instance == null) {
                    instance = new ASingletonByReentrantLock();
                }
            }
            finally {
                lock.unlock();
            }
        }
        return instance;
    }
    public static void main(String[] args) {
        AtomicReference<ASingletonByReentrantLock> o1 = new AtomicReference<>();
        Runnable r = () -> {
            String tname = Thread.currentThread().getName();
            System.out.println(tname + " Started");
            ASingletonByReentrantLock s = ASingletonByReentrantLock.getInstance();
            if (o1.get() == null) {
                o1.set(s);
            } else if (o1.get().equals(s)) {
                System.out.println("just create singleton instance");
            } else {
                System.out.println("create new instance");

            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Thread t1 = new Thread(r, "T1");
        Thread t2 = new Thread(r, "T2");
        t1.start();
        t2.start();
    }
}
