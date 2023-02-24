package com.caozeal.leetcode.before20230224;

public class LRUCache {

    private int capacity;

    private int size = 0;

    private Node[] vals;

    private Node head = new Node(null, null, 0);

    private Node tail = new Node(null, null, 0);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        vals = new Node[10000];
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node val = vals[key];
        if(val == null || val.next == null){
            return -1;
        }
        use(val);
        return val.value;
    }

    private void use(Node val) {
        val.pre.next = val.next;
        val.next.pre = val.pre;
        val.next = head.next;
        val.pre = head;
        head.next.pre = val;
        head.next = val;
    }

    public void put(int key, int value) {
        Node val = vals[key];
        if(val == null|| val.next == null){
            val = new Node(head, head.next, value);
            head.next.pre = val;
            head.next = val;
            vals[key] = val;
            if(++size > capacity){
                tail.pre.pre.next = tail;
                tail.pre.next = null;
                tail.pre = tail.pre.pre;
                size--;
            }
            return;
        }
        val.value = value;
        use(val);
    }

    static class Node{
        private Node pre;

        private Node next;

        private int value;

        public Node(Node pre, Node next, int value) {
            this.pre = pre;
            this.next = next;
            this.value = value;
        }
    }
}