package com.example.cacheManager;

import java.util.ArrayList;
import java.util.List;

public class Cache {
    private List<CacheEntry> cache;
    private int cacheSize;

    public Cache(int size) {
        cacheSize = size;
        cache = new ArrayList<>(cacheSize);
        for (int i = 0; i < cacheSize; i++) {
            cache.add(new CacheEntry(i, -1)); // Inicializa o cache com objetos CacheEntry vazios.
        }
    }

    public boolean checkCache(int data) {
        for (CacheEntry entry : cache) {
            if (entry.getData() == data) {
                return true; // Hit no cache
            }
        }

        // Simular atraso de acesso ao cache
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Substituir o objeto CacheEntry mais antigo
        CacheEntry newEntry = new CacheEntry(data % cacheSize, data);
        cache.set(data % cacheSize, newEntry);

        return false; // Miss no cache
    }

    public int getCacheSize() {
        return cacheSize;
    }

    public int getCacheData(int index) {
        return cache.get(index).getData();
    }

    public void printCache() {
        for (CacheEntry entry : cache) {
            System.out.println("Index: " + entry.getIndex() + " Data: " + entry.getData());
        }
    }
}
