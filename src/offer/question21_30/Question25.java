package offer.question21_30;

import xu.linkedlist.ListNode;
import xu.linkedlist.SinglyLinkedListUtil;

public class Question25 {

    public static void main(String[] args) {
        ListNode h1 = SinglyLinkedListUtil.buildLinkedList(new int[]{1});
        ListNode h2 = SinglyLinkedListUtil.buildLinkedList(new int[]{1});
        ListNode head = Merge(h1, h2);
        SinglyLinkedListUtil.printList(head);
    }

    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;

        while (p1 != null && p2 != null){
            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
            }
            else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }

        if (p1 != null)
            p.next = p1;

        if (p2 != null)
            p.next = p2;

        return dummy.next;
    }

}
