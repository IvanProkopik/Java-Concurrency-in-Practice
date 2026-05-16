package org.week02_race_condition;

public class CounterScenarioRunner {

    private Counter counter;
    private int threadCount;
    private int incrementsPerThread;

    public CounterScenarioRunner(Counter counter, int threadCount, int incrementsPerThread) {
        this.counter = counter;
        this.threadCount = threadCount;
        this.incrementsPerThread = incrementsPerThread;
    }

    public void runScenario() {

        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {

            threads[i] = new Thread(() -> {

                for (int j = 0; j < incrementsPerThread; j++) {
                    counter.increment();
                }

            });

            threads[i].start();
        }

        for (int i = 0; i < threadCount; i++) {

            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int expectedValue() {
        return threadCount * incrementsPerThread;
    }

    public Counter getCounter() {
        return counter;
    }
}