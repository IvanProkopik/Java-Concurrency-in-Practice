package org.demo.week02_race_condition;


public class SynchronizedCounter implements Counter {

    private int value;

    @Override
    public synchronized void increment() {
        value++;
    }

    @Override
    public synchronized int getValue() {
        return value;
    }
}