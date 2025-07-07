public class Main {
    static int counter = 0;

    public static void main(String[] args) {
        try {
            Thread t1 = new Thread(createRunnable(), "Thread 1");
            Thread t2 = new Thread(createRunnable(), "Thread 2");
            t1.start();
            t2.start();
//            t1.join();
//            t2.join();
            System.out.println(String.format("Main Thread ended from Thread: %s", Thread.currentThread().getName()));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static Runnable createRunnable() {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        counter++;
                        System.out.println(String.format("Counter val:%d  from %s",counter, Thread.currentThread().getName()));

                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }
        };
    }

    static void testThread() {


    }
}



