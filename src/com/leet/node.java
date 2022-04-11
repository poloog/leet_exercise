package com.leet;

public class node {
    public static class ListNode {
        public int val = 0;
        public ListNode next = null;
        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5, 6};
        ListNode head = createLinkList(nums);
        reorderList(head);
        while(head != null) {
            System.out.print(head.val);
            System.out.print(" ");
            head = head.next;
        }
    }

    public static ListNode createLinkList(int[] nums) {
        ListNode node = new ListNode();
        ListNode p = node;
        for(int i : nums) {
            p.next = new ListNode(i);
            p = p.next;
        }
        return node.next;
    }

    public static void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != null) {
            ListNode t = slow.next;
            slow.next = null;
            slow = t;
        }else {
            ListNode t = head;
            while(t.next != slow) {
                t = t.next;
            }
            t.next = null;
        }
        slow = reverseListNode(slow);
        mergeListNode(head, slow);
    }

    public static ListNode reverseListNode(ListNode node) {
        ListNode pre = null;
        ListNode next = null;
        ListNode p = node;
        while(p != null) {
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }

    public static void mergeListNode(ListNode a, ListNode b) {
        ListNode p1 = a;
        ListNode p2 = b;
        ListNode t = null;
        while(p1 != null && p2 != null) {
            t = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = t;
        }
    }


}
