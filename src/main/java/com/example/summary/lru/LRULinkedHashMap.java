package com.example.summary.lru;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * @description: LRU缓存结构设计 该版本我简单起见，直接用linkedhashmap实现
 * @author: icecrea
 * @create: 2019-10-16
 **/
public class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    private int capacity;

    LRULinkedHashMap(int capacity) {
        super(capacity, 0.75f, true);
        //传入指定的缓存最大容量
        this.capacity = capacity;
    }

    /**
     * 实现LRU的关键方法，如果map里面的元素个数大于了缓存最大容量，则删除链表的顶端元素
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        // 10是初始大小，0.75是装载因子，true是表示按照访问时间排序
        HashMap<Integer, Integer> m = new LinkedHashMap<>(10, 0.75f, true);
        m.put(3, 11);
        m.put(1, 12);
        m.put(5, 23);
        m.put(2, 22);
        m.put(3, 26);
        m.get(5);
        for (Map.Entry e : m.entrySet()) {
            System.out.println(e.getKey());
        }

        LRULinkedHashMap lruLinkedHashMap = new LRULinkedHashMap(3);
        lruLinkedHashMap.put(3, 11);
        lruLinkedHashMap.put(1, 12);
        lruLinkedHashMap.put(5, 23);
        lruLinkedHashMap.put(2, 22);
        lruLinkedHashMap.put(3, 26);
        lruLinkedHashMap.get(5);
        System.out.println(Lists.newArrayList(lruLinkedHashMap.entrySet()));

//        for(Iterator<Map.Entry<Integer,Integer>> it = lruLinkedHashMap.entrySet().iterator(); it.hasNext();){
//            System.out.println(it.next().getKey());
//        }
    }
}
