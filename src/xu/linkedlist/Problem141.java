package xu.linkedlist;

/**
 * Problem 141 Linked List Cycle
 */

public class Problem141 extends SinglyLinkedListUtil {

    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = head;
        ListNode prev = dummy;
        while (p.next != null){
            if (p.next.next == dummy){
                return true;
            }
            prev = p;
            p = p.next;
            prev.next = dummy;
        }
        return false;
    }



}
