package 链表;

public class reverse {
    public ListNode reverse_(ListNode root) {
        ListNode pre = null;
        ListNode next = root;
        while (next != null) {
            next = root.next;
            root.next = pre;
            pre = root;
            root = next;
        }
        return pre;
    }
}
