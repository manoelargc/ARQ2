package com.example.cacheManager;
public class DirectMappedCache extends Cache {
    public DirectMappedCache(int size) {
        super(size);
    }

    @Override
    public boolean checkCache(int data) {
        // Implementação específica do cache de mapeamento direto
        int index = data % getCacheSize();
        if (getCacheData(index) == data) {
            return true; // Hit no cache
        } else {
            // Simular atraso de acesso ao cache
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setCacheData(index, data); // Substituir o dado no cache
            return false; // Miss no cache
        }
    }
}
