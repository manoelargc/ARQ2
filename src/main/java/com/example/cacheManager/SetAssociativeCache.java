package com.example.cacheManager;

import java.util.ArrayList;
import java.util.List;

public class SetAssociativeCache extends Cache {
    private int numSets;
    private List<List<Integer>> cacheSets;

    public SetAssociativeCache(int numSets, int size) {
        super(size);
        this.numSets = numSets;
        cacheSets = new ArrayList<>(numSets);
        for (int i = 0; i < numSets; i++) {
            cacheSets.add(new ArrayList<>());
        }
    }

    @Override
    public boolean checkCache(int data) {
        // Implementação específica do cache associativa por conjuntos
        int setIndex = data % numSets;
        List<Integer> cacheSet = cacheSets.get(setIndex);

        if (cacheSet.contains(data)) {
            return true; // Hit no cache
        } else {
            // Simular atraso de acesso ao cache
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Substituir o objeto CacheEntry mais antigo
            if (cacheSet.size() >= getCacheSize() / numSets) {
                cacheSet.remove(0);
            }
            cacheSet.add(data);
            return false; // Miss no cache
        }
    }
}