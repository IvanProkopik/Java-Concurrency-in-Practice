package org.week04_composing_objects;

public class UserLoaderStub {
    private final long artificialDelayMillis;

    public UserLoaderStub(long artificialDelayMillis) {
        this.artificialDelayMillis = artificialDelayMillis;
    }

    public UserProfile loadById(String id) {
        try {
            System.out.println(Thread.currentThread().getName() + "load user:" + id);

            Thread.sleep(artificialDelayMillis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return new UserProfile(id, "User-" + id, id + "gmail.com");
    }
}
