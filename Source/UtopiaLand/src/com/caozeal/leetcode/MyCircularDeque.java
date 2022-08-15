package com.caozeal.leetcode;

class MyCircularDeque {

    public static void main(String[] args) {
        MyCircularDeque deque = new MyCircularDeque(3);
        deque.insertLast(1);
        deque.insertLast(2);
        deque.insertFront(3);
        deque.insertFront(4);
    }

    private int[] val;

    private int head;

    private int tail;

    public MyCircularDeque(int k) {
        val = new int[k];
        head = -1;
        tail = -1;
    }

    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        if(isEmpty()){
            head = 0;
            tail = 0;
        }else if(head == 0){
            head = val.length - 1;
        }else {
            head--;
        }
        val[head] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        if(isEmpty()){
            head = 0;
            tail = 0;
        }else if(tail == val.length - 1){
            tail = 0;
        }else {
            tail++;
        }
        val[tail] = value;
        return true;
    }

    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        if(head == tail){
            head = -1;
            tail = -1;
        }else if(head == val.length -1){
            head = 0;
        }else{
            head++;
        }
        return true;
    }

    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        if(head == tail){
            head = -1;
            tail = -1;
        }else if(tail == 0){
            tail = val.length - 1;
        }else{
            tail--;
        }
        return true;
    }

    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        return val[head];
    }

    public int getRear() {
        if(isEmpty()){
            return -1;
        }
        return val[tail];
    }

    public boolean isEmpty() {
        return head == -1;
    }

    public boolean isFull() {
        return head - tail == 1 || (head == 0 && tail == val.length-1);
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */