package org.week01_thread_lifecycle;


public class Week01App {

    public static void main(String[] args) throws InterruptedException {
        ThreadWorker t1 = new ThreadWorker("ThreadWorker", 5, 300);
        Thread t2 = new Thread(new RunnableWorker("RunnableWorker", 5, 300));

        startAndJoin(t1);
        startAndJoin(t2);

        System.out.println("----- run()-----");

        RunnableWorker r = new RunnableWorker("DirectRun", 5, 300);
        callRunDirectly(r);

        Thread.sleep(1000);
    }

    public static void startAndJoin(Thread t) throws InterruptedException {
        t.start();
        t.join();
    }

    public static void callRunDirectly(Runnable r) {
        r.run();
    }
}
