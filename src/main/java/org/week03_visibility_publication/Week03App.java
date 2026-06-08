package org.week03_visibility_publication;

public class Week03App {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("===== StopFlagDemo =====");

        StopFlagDemo stopFlagDemo = new StopFlagDemo();

        Thread t1 = new Thread(stopFlagDemo::workerLoop);
        t1.start();

        Thread.sleep(1000);

        System.out.println("Main thread викликає stopWork()");
        stopFlagDemo.stopWork();

        t1.join(2000);

        System.out.println("\n===== VolatileStopFlagDemo =====");

        VolatileStopFlagDemo volatileDemo = new VolatileStopFlagDemo();

        Thread t2 = new Thread(volatileDemo::workerLoop);
        t2.start();

        Thread.sleep(1000);

        System.out.println("Main thread викликає stopWork()");
        volatileDemo.stopWork();

        t2.join();

        System.out.println("\n===== ImmutableRequestConfig =====");

        ImmutableRequestConfig config = new ImmutableRequestConfig("PaymentService", 5000, true);

        Runnable configTask = () -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Service: " + config.getServiceName());
            System.out.println("Timeout: " + config.getTimeoutMillis());
            System.out.println("Fallback: " + config.isFallbackEnabled());
        };

        Thread configThread1 = new Thread(configTask, "Config-Thread-1");
        Thread configThread2 = new Thread(configTask, "Config-Thread-2");

        configThread1.start();
        configThread2.start();

        configThread1.join();
        configThread2.join();

        System.out.println("\n===== ThreadLocal Demo =====");

        Runnable requestTask = () -> {

            String requestId = Thread.currentThread().getName() + "-REQ";

            RequestContextHolder.setRequestId(requestId);

            System.out.println(Thread.currentThread().getName() + " бачить requestId = " + RequestContextHolder.getRequestId());
            RequestContextHolder.clear();
        };

        Thread request1 = new Thread(requestTask, "Request-1");
        Thread request2 = new Thread(requestTask, "Request-2");

        request1.start();
        request2.start();

        request1.join();
        request2.join();

        System.out.println("\n===== Завершено =====");
    }
}
