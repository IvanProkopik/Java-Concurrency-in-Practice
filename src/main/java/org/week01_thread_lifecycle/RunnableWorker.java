package org.week01_thread_lifecycle;


public class RunnableWorker implements Runnable {

    private String workerName;
    private int iterations;
    private long pauseMillis;

    public RunnableWorker(String workerName, int iterations, long pauseMillis) {
        this.workerName = workerName;
        this.iterations = iterations;
        this.pauseMillis = pauseMillis;
    }

    @Override
    public void run() {
        for (int i = 1; i <= iterations; i++) {
            printStep(i);
            try {
                Thread.sleep(pauseMillis);
            } catch (InterruptedException e) {
                System.out.println(workerName + " interrupted!");
                return;
            }
        }
    }

    private void printStep(int step) {
        System.out.println(Thread.currentThread().getName() +
                " [" + workerName + "] step: " + step);
    }
}
