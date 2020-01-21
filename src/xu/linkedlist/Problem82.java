package xu.linkedlist;

import java.util.List;

/**
 * problem 82. Remove Duplicates from Sorted List II
 */

public class Problem82 extends SinglyLinkedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        boolean flag = false;
        ListNode prev = dummy;
        ListNode p = head;
        ListNode pnext = null;

        while (p != null && p.next != null){
            pnext = p.next;
            while (pnext != null && pnext.val == p.val){
                p.next = pnext.next;
                pnext = pnext.next;
                flag = true;
            }
            if (flag){
                prev.next = p.next;
                flag = false;
            }else {
                prev = p;
            }
            p = p.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        Problem82.addNode(head,1,0);
        Problem82.addNode(head,1,0);
        Problem82.addNode(head,1,0);
        Problem82.addNode(head,1,0);
        Problem82.addNode(head,1,0);
        Problem82.addNode(head,1,0);

        Problem82.printList(head);
        ListNode node = new Problem82().deleteDuplicates(head);
        Problem82.printList(node);
    }

}
