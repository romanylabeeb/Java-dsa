package dsa.mustafaSaad.thread;

class Message {
    public String msg;

    Message(String m) {
        this.msg = m;
    }
}

class Waiter implements Runnable {
    private Message msg;

    public Waiter(Message m) {
        this.msg = m;
    }

    @Override
    public void run() {
        String tName = Thread.currentThread().getName();
        System.out.println(tName + " Started...");

        synchronized (msg) {
            try {
                System.out.println("waiting msg notification at time: " + System.currentTimeMillis());
                msg.wait();
                System.out.println("Waiter thread got notified at time:" + System.currentTimeMillis());
                System.out.println(tName + " processed: " + msg.msg);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);

            }
        }
    }
}

class Notifier implements Runnable {
    private Message msg;

    public Notifier(Message m) {
        this.msg = m;
    }

    @Override
    public void run() {
        String tName = Thread.currentThread().getName();
        System.out.println(tName + " started ...");
        try {
            synchronized (msg) {
                Thread.sleep(2000);
                msg.msg = " new msg";
                msg.notifyAll();
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class ConsumerProducerImpl {
    public static void main(String[] args) {
        Message msg=new Message("hello");
        Thread w1=new Thread( new Waiter(msg),"w1");
        w1.start();

        Thread w2=new Thread( new Waiter(msg),"w2");
        w2.start();

        Thread n1=new Thread(new Notifier(msg),"N1");
        n1.start();
        System.out.println("all threads are started");
    }

}
