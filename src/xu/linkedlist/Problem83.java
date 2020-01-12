package xu.linkedlist;

/**
 * problem 83. Remove Duplicates from Sorted List
 */

public class Problem83 extends SinglyLinkedList {


    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = head;
        ListNode pnext = null;

        while (prev != null && prev.next != null){
            pnext = prev.next;
            while (pnext != null && pnext.val == prev.val){
                prev.next = pnext.next;
                pnext = pnext.next;
            }
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        Problem83.addNode(head,1);
        Problem83.addNode(head,1);
        Problem83.addNode(head,1);
        Problem83.addNode(head,1);
        Problem83.addNode(head,1);
        Problem83.addNode(head,1);

        Problem83.printList(head);
        new Problem83().deleteDuplicates(head);
        Problem83.printList(head);
    }

}
