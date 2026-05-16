package org.week02_race_condition;

public class Week02App {

    public static void main(String[] args) {

        runUnsafeCase();

        System.out.println();

        runSynchronizedCase();

        System.out.println();

        runAtomicCase();
    }

    public static void runUnsafeCase() {

        System.out.println("UnsafeCounter");

        for (int i = 1; i <= 5; i++) {

            CounterScenarioRunner runner = new CounterScenarioRunner(new UnsafeCounter(), 50, 10000);

            runner.runScenario();

            System.out.println("Run " + i + " | Expected: " + runner.expectedValue() + " | Actual: " + runner.getCounter().getValue());
        }
    }

    public static void runSynchronizedCase() {

        System.out.println("SynchronizedCounter");

        CounterScenarioRunner runner = new CounterScenarioRunner(new SynchronizedCounter(), 50, 10000);

        runner.runScenario();

        System.out.println("Expected: " + runner.expectedValue() + " | Actual: " + runner.getCounter().getValue());
    }

    public static void runAtomicCase() {

        System.out.println("AtomicCounter");

        CounterScenarioRunner runner = new CounterScenarioRunner(new AtomicCounter(), 50, 10000);

        runner.runScenario();

        System.out.println("Expected: " + runner.expectedValue() + " | Actual: " + runner.getCounter().getValue());
    }
}
