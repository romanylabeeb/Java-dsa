package dsa.mustafaSaad.thread;

import java.util.concurrent.atomic.AtomicReference;

public class ASingleton {
    private static volatile ASingleton instance;
    private static final Object mutex = new Object();
    private ASingleton() {

    }
    public static ASingleton getInstance() {
        ASingleton res = instance;
        if (instance == null) {
            synchronized (mutex) {
                if (instance == null) {
                    System.out.println("Create new instance by " + Thread.currentThread().getName() + " thread");
                    instance = new ASingleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        AtomicReference<ASingleton> o1 = new AtomicReference<>();
        Runnable r = () -> {
            String tname = Thread.currentThread().getName();
            System.out.println(tname + " Started");
            ASingleton s = ASingleton.getInstance();
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
