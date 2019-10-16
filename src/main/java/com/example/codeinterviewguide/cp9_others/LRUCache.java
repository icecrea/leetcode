package com.example.codeinterviewguide.cp9_others;

import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description: LRU缓存结构设计 该版本我简单起见，直接用linkedhashmap实现
 * @author: icecrea
 * @create: 2019-10-16
 **/
public class LRUCache<K, V> {

    private static final float hashTableLoadFactor = 0.75f;
    private LinkedHashMap<K, V> map;
    private int cacheSize;

    public LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
        int hashTableCapacity = (int) Math.ceil(cacheSize / hashTableLoadFactor) + 1;
        map = new LinkedHashMap<K, V>(hashTableCapacity, hashTableLoadFactor, true) {
            private static final long serialVersionUID = 1;

            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > LRUCache.this.cacheSize;
            }
        };
    }

    public synchronized V get(K key) {
        return map.get(key);
    }

    public synchronized void put(K key, V value) {
        map.put(key, value);
    }

    public synchronized Collection<Map.Entry<K, V>> getAll() {
        return Lists.newArrayList(map.entrySet());
    }
}
