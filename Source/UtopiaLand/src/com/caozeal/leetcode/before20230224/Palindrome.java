package com.caozeal.leetcode.before20230224;

public class Palindrome {

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        ListNode tail = new ListNode(1);
        ListNode a = new ListNode(2, tail);
        ListNode b = new ListNode(1, a);
        ListNode c = new ListNode(1, b);
        ListNode d = new ListNode(1, c);
        ListNode e = new ListNode(2, d);
        ListNode head = new ListNode(1, e);
        System.out.println(palindrome.isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head.next;
        if(slow == null){
            return true;
        }
        ListNode fast = slow.next;
        if(fast == null){
            return slow.val == head.val;
        }
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        ListNode flip = flip(mid);
        mid.next = null;
        while (head != null){
            if(flip.val != head.val){
                return false;
            }
            flip = flip.next;
            head = head.next;
        }
        return true;
    }

    private ListNode flip(ListNode node){
        ListNode pre = node.next;
        if(pre == null){
            return node;
        }
        ListNode old = pre.next;
        while (old != null){
            pre.next = node;
            node = pre;
            pre = old;
            old = old.next;
        }
        pre.next = node;
        return pre;
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
