package org.nava.year21.may;

// Linked list operations
// LinkedListNode(int data)
// LinkedListNode(int key, int data)
// LinkedListNode(int data, LinkedListNode next)
// LinkedListNode(int data, LinkedListNode next, LinkedListNode arbitrary_pointer)

import java.util.*;

class LRUCache {
    int capacity;

    //LinkedListNode holds key and value pairs
    Set<Integer> cache;
    LinkedList<LinkedListNode> cacheVals;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashSet<Integer>(capacity);
        cacheVals = new LinkedList<LinkedListNode>();
    }

    LinkedListNode get(int key) {
        if (!cache.contains(key)) {

            return null;
        } else {

            ListIterator<LinkedListNode> iterator1 = cacheVals.listIterator(0);
            while (iterator1.hasNext()) {
                LinkedListNode node = iterator1.next();
                if (node.key == key) {
                    return node;
                }
            }
            return null;
        }
    }

    void set(int key, int value) {
        LinkedListNode node = get(key);

        if (node == null) {
            evictIfNeeded();
            node = new LinkedListNode(key, value);
            cacheVals.addLast(node);
            cache.add(key);
        } else {
            cacheVals.remove(node);
            cacheVals.addLast(node);
        }
    }

    void evictIfNeeded() {
        if (cacheVals.size() >= capacity) {
            LinkedListNode node = cacheVals.remove();
            cache.remove(node.key);

        }
    }

    void print() {
        ListIterator<LinkedListNode> iterator = cacheVals.listIterator(0);
        while (iterator.hasNext()) {
            LinkedListNode node = iterator.next();
            System.out.print("(" + node.key + "," + node.data + ")");
        }
        System.out.println("");


    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.set(10, 20);
        cache.print();

        cache.set(15, 25);
        cache.print();

        cache.set(20, 30);
        cache.print();

        cache.set(25, 35);
        cache.print();

        cache.set(5, 25);
        cache.print();
    }
}

class LinkedListNode {
    public int data;
    public int key;
    public LinkedListNode next;

    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }

    public LinkedListNode(int key,int data) {
        this.data = data;
        this.next = null;
        this.key = key;
    }

    public LinkedListNode(int data, LinkedListNode next) {
        this.data = data;
        this.next = next;
    }
}
