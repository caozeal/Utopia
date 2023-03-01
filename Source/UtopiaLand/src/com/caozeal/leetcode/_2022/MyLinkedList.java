package com.caozeal.leetcode._2022;

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
class MyLinkedList {

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(2);
        linkedList.deleteAtIndex(1);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        linkedList.addAtIndex(3,4);   //链表变为1-> 2-> 3->4
        linkedList.addAtIndex(-1,5);   //链表变为5 ->1-> 2-> 3->4
        System.out.println(linkedList.get(1));            //返回1
        linkedList.deleteAtIndex(1);  //现在链表是5-> 2-> 3->4
        linkedList.deleteAtIndex(0);  //现在链表是2-> 3->4
        System.out.println(linkedList.get(1));            //返回3
        System.out.println(linkedList.get(0));            //返回2
        System.out.println(linkedList.get(2));            //返回4
    }

    private Node head = null;

    private Node tail = null;

    public MyLinkedList() {
    }

    public int get(int index) {
        if(head == null){
            return -1;
        }
        Node node = head;
        for (int i = index; i > 0; i--) {
            node = node.next;
            if(node == null){
                return -1;
            }
        }
        return node.val;
    }

    public void addAtHead(int val) {
        if(head == null){
            head = new Node(val);
            tail = head;
            return;
        }
        Node node = new Node(val);
        node.next = head;
        head = node;
    }

    public void addAtTail(int val) {
        if(head == null){
            head = new Node(val);
            tail = head;
            return;
        }
        tail.next = new Node(val);
        tail = tail.next;
    }

    public void addAtIndex(int index, int val) {
        if(index < 0 || index == 0){
            addAtHead(val);
            return;
        }
        if(head == null){
            return;
        }
        Node node = head;
        for (int i = 1; i < index; i++) {
            node = node.next;
            if(node == null){
                return;
            }
        }
        Node add = new Node(val);
        add.next = node.next;
        node.next = add;
        if(add.next == null){
            tail = add;
        }
    }

    public void deleteAtIndex(int index) {
        if(head == null || index < 0){
            return;
        }
        if(index == 0){
            head = head.next;
            return;
        }
        Node node = head;
        for (int i = 1; i < index; i++) {
            node = node.next;
            if(node.next == null){
                return;
            }
        }
        if(node.next == null){
            return;
        }
        node.next = node.next.next;
        if(node.next == null){
            tail = node;
        }
    }

    private static class Node{
        int val;

        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}