package com.caozeal.leetcode;

public class HasCycle {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            head = head.next;
            if(fast == head){
                return true;
            }
        }
        return false;
    }

    class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }

}
