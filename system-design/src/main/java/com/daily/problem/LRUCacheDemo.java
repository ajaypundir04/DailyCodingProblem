package com.daily.problem;

import java.util.LinkedHashMap;

class LRUCache<K, V> {
    private final LinkedHashMap<K, V> cache = new LinkedHashMap<K, V>();
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public void put(K key, V value) {
        if (cache.size() == this.capacity) {
            cache.remove(cache.keySet().iterator().next());
        }
        cache.remove(key);
        cache.put(key, value);
    }

    public V get(K key) {
        if (cache.containsKey(key)) {
            V value = cache.get(key);
            cache.remove(key);
            cache.put(key, value);
            return value;
        }
        return null;
    }

    public LinkedHashMap<K, V> getCache() {
        return cache;
    }
}

public class LRUCacheDemo {
    public static void main(String[] args) {
        LRUCache<Integer, Integer> lru = new LRUCache<>(5);
        for (int i = 0; i < 10; i++) {
            lru.put(i, i * 2);
            lru.getCache().entrySet()
                    .forEach(entry ->
                            System.out.println(String.format("Key %s Value %s", entry.getKey(), entry.getValue())));
        }
    }
}
