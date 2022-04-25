package 链表.合并K个升序链表;

import 链表.ListNode;

public class MergeKLIsts {

    public ListNode mergeKLists(ListNode[] lists) {
        return process(lists, 0, lists.length - 1);
    }

    // 归并
    public ListNode process(ListNode[] list, int left, int right) {
        if (left == right) return list[left];
        if (left > right) return null;
        int middle = left + (right - left) / 2;
        return merge(process(list, left, middle), process(list, middle + 1, right));
    }

    // 朴素的遍历
    public ListNode mergeKLists1(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) return null;
        if (len == 1) return lists[0];
        ListNode result = merge(lists[0], lists[1]);
        for (int i = 2; i < len; i++) {
            result = merge(result, lists[i]);
        }
        return result;
    }



    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode p = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                p.next = list1;
                list1 = list1.next;
                p = p.next;
                p.next = null;
            } else {
                p.next = list2;
                list2 = list2.next;
                p = p.next;
                p.next = null;
            }
        }
        if (list1 != null) {
            p.next = list1;
        }
        if (list2 != null) {
            p.next = list2;
        }
        return head.next;
    }
}
