package com.example.cacheManager;

import java.util.LinkedHashMap;
import java.util.Map;

public class FullyAssociativeCache extends Cache {
    private final int size;
    private final Map<Integer, Integer> cache;

    public FullyAssociativeCache(int size) {
        this.size = size;
        this.cache = new LinkedHashMap<Integer, Integer>(size, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > size;
            }
        };
    }

    public boolean checkCache(int data) {
        if (cache.containsKey(data)) {
            return true; // Hit no cache
        } else {
            // Miss no cache, substituir o bloco de dados menos recentemente usado
            cache.put(data, data);
            return false;
        }
    }
}
