package org.week04_composing_objects;

import java.util.ArrayList;
import java.util.List;

public class Week04App {
    public static void main(String[] args) throws InterruptedException {

        UserLoaderStub loader = new UserLoaderStub(1000);

        System.out.println("=== SYNCHRONIZED CACHE ===");
        runScenario("Synchronized", new SynchronizedUserCache(loader));

        System.out.println("\n=== CONCURRENT CACHE ===");
        runScenario("Concurrent", new ConcurrentUserCache(loader));

        System.out.println("\n=== DIFFERENT IDS TEST ===");
        runDifferentIdsScenario(new ConcurrentUserCache(loader));
    }

    private static void runScenario(String cacheName, Object cache) throws InterruptedException {

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            Thread thread = new Thread(() -> {

                UserProfile profile;

                if (cache instanceof SynchronizedUserCache synchronizedCache) {
                    profile = synchronizedCache.getById("user-42");
                } else {
                    profile = ((ConcurrentUserCache) cache).getById("user-42");
                }

                System.out.println(Thread.currentThread().getName() + " got: " + profile
                );

            });

            threads.add(thread);
        }

        long start = System.currentTimeMillis();

        threads.forEach(Thread::start);

        for (Thread thread : threads) {
            thread.join();
        }

        long end = System.currentTimeMillis();

        System.out.println(cacheName + " execution time: " + (end - start) + " ms");
    }

    private static void runDifferentIdsScenario(ConcurrentUserCache cache) throws InterruptedException {

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            int id = i;

            Thread thread = new Thread(() -> {

                UserProfile profile = cache.getById("user-" + id);

                System.out.println(
                        Thread.currentThread().getName() + " got: " + profile);
            });

            threads.add(thread);
        }
        long start = System.currentTimeMillis();

        threads.forEach(Thread::start);

        for (Thread thread : threads) {
            thread.join();
        }
        long end = System.currentTimeMillis();

        System.out.println(" execution time: " + (end - start) + " ms");
    }
}
