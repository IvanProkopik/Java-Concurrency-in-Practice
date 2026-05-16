package org.demo;

public class SimpleSingleton {
    private static final SimpleSingleton simpleSingleton = new SimpleSingleton();

    private SimpleSingleton() {
    }

    public static SimpleSingleton getInstance(){
        return simpleSingleton;
    }
}
