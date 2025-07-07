package dsa.mustafaSaad.thread;

import java.util.Timer;
import java.util.TimerTask;

public class TimerExample {

    // Define a TimerTask to print a message
    static class MyTask extends TimerTask {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+ " Thread ,Task executed at: " + System.currentTimeMillis());
            System.out.println("is daemon thread: "+Thread.currentThread().isDaemon());
        }
    }

    public static void main(String[] args) {
        // Create a Timer
        Timer timer = new Timer();

        // Schedule the task to run every 2 seconds (2000 milliseconds)
        timer.schedule(new MyTask(), 0, 2000);

        // Optionally, schedule a task to stop the timer after some time
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Stopping the timer...");
                timer.cancel();
            }
        }, 10000); // Stop after 10 seconds
        System.out.println(Thread.currentThread().getName()+ " Thread is done");
    }
}
