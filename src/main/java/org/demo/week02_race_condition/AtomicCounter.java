package org.demo.week02_race_condition;


import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter implements Counter {

    private AtomicInteger value = new AtomicInteger();

    @Override
    public void increment() {
        value.incrementAndGet();
    }

    @Override
    public int getValue() {
        return value.get();
    }
}