package com.example.codeinterviewguide.cp9_others.lru;

/**
 * @description: 缓存结构，双端队列和哈希表
 * @author: icecrea
 * @create: 2019-10-16
 **/
public class Node<V> {

    public V value;
    public Node<V> last;
    public Node<V> next;

    public Node(V value){
        this.value = value;
    }
}
