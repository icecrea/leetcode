package com.example.summary.lru;

import java.util.*;

/**
 * @description: 双向链表LinkedList和HashMap来实现LRU算法
 * 通过双向链表LinkedList和HashMap来实现LRU算法。因为从map中删除元素需要知道key，所以双向链表存放key。
 * 注意：时间复杂度比较高，问题在于linkedlist的移除操作，时间复杂度是O(N)的，map只定位到了元素，但从双向链表中定位还是从头开始遍历的过程。所以并不是真正想要的LRU算法
 * @author: icecrea
 * @create: 2020-01-02
 **/
public class LRUCacheBeta<K, V> {
    int capacity;
    Map<K, V> map;
    LinkedList<K> list;

    public LRUCacheBeta(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.list = new LinkedList<>();
    }

    /**
     * 添加元素
     * 1.元素存在，放到队尾
     * 2.不存在，判断链表是否满。
     * 如果满，则删除队首元素，放入队尾元素，删除更新哈希表
     * 如果不满，放入队尾元素，更新哈希表
     */
    public void put(K key, V value) {
        V v = map.get(key);
        if (v != null) {
            list.remove(key);
            list.addLast(key);
            map.put(key, value);
            return;
        }

        //队列未满，添加到尾部
        if (list.size() < capacity) {
            list.addLast(key);
            map.put(key, value);
        } else {
            //队列已满，移除队首
            K firstKey = list.removeFirst();
            map.remove(firstKey);
            list.addLast(key);
            map.put(key, value);
        }
    }

    /**
     * 访问元素
     * 1.元素存在，放到队尾
     */
    public V get(K key) {
        V v = map.get(key);
        if (v != null) {
            list.remove(key);
            list.addLast(key);
            return v;
        }
        return null;
    }


    public static void main(String[] args) {
        LRUCacheBeta cache = new LRUCacheBeta(2);
        cache.put(2, 1);
        cache.put(1, 2);
        cache.put(2, 3);
        System.out.println(cache.map.entrySet());

        cache.put(4, 1);
        System.out.println(cache.map.entrySet());

        cache.get(1);
        System.out.println(cache.map.entrySet());

        cache.get(2);
        System.out.println(cache.map.entrySet());
    }

}
