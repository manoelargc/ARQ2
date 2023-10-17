package com.example.cacheManager;

import java.util.ArrayList;
import java.util.List;

public class CacheEntry {
    private int index;
    private int data;

    public CacheEntry(int index, int data) {
        this.index = index;
        this.data = data;
    }

    public int getIndex() {
        return index;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data=data;
    }
}
