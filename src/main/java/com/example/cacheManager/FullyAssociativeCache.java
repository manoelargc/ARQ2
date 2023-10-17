package com.example.cacheManager;


public class FullyAssociativeCache extends Cache {
    public FullyAssociativeCache(int size) {
        super(size);
    }

    @Override
    public boolean checkCache(int data) {
        // Implementação específica do cache totalmente associativo
        for (int i = 0; i < getCacheSize(); i++) {
            if (getCacheData(i) == data) {
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
        setCacheData(0, data);
        return false; // Miss no cache
    }
}