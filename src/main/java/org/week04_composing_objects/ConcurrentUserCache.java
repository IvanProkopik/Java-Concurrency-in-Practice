package org.week04_composing_objects;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentUserCache {
    private final Map<String, UserProfile> cache = new ConcurrentHashMap<>();
    private final UserLoaderStub loader;

    public ConcurrentUserCache(UserLoaderStub loader) {
        this.loader = loader;
    }

    public UserProfile getById(String id) {
        return cache.computeIfAbsent(id, loader::loadById);
    }
}
