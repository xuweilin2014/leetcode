package offer.question21_30;

import xu.linkedlist.ListNode;
import xu.linkedlist.SinglyLinkedListUtil;

public class Question24 {

    public static void main(String[] args) {
        ListNode head = SinglyLinkedListUtil.buildLinkedList(new int[]{1,2,3});
        head = ReverseList(null);
        SinglyLinkedListUtil.printList(head);
    }

    public static ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head.next;
        ListNode prev = null;
        while (fast != null){
            slow.next = prev;
            prev = slow;
            slow = fast;
            fast = fast.next;
        }

        slow.next = prev;

        return slow;
    }

}
