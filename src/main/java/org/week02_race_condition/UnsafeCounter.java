package org.week02_race_condition;

public class UnsafeCounter implements Counter {

    private int value;

    @Override
    public void increment() {
        value++;
    }

    @Override
    public int getValue() {
        return value;
    }
}
