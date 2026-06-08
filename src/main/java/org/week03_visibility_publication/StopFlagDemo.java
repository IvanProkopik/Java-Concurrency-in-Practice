package org.week03_visibility_publication;

public class StopFlagDemo {
    private boolean running = true;

    public void workerLoop() {
        long counter = 0;

        while (running) {
            counter++;

            if (counter % 100_000_000 == 0) {
                System.out.println(Thread.currentThread().getName()
                        + " працює... counter = " + counter);
            }
        }

        System.out.println("Worker thread зупинений.");
    }

    public void stopWork() {
        running = false;
    }
}
