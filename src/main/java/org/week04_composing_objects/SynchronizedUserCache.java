package org.week04_composing_objects;

import java.util.HashMap;
import java.util.Map;

public class SynchronizedUserCache {
    private final Map<String, UserProfile> cache = new HashMap<>();
    private final Object lock = new Object();
    private final UserLoaderStub loader;

    public SynchronizedUserCache(UserLoaderStub loader) {
        this.loader = loader;
    }

    public UserProfile getById(String id) {
        synchronized (lock){
            UserProfile cached = cache.get(id);

            if (cached != null){
                return cached;
            }

            UserProfile loaded = loader.loadById(id);

            cache.put(id, loaded);
            return loaded;
        }
    }
}
