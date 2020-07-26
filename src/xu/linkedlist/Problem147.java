package xu.linkedlist;

import java.awt.*;

/**
 * problem 147. Insertion Sort List
 */
public class Problem147 extends SinglyLinkedListUtil {

    public static ListNode insertionSortList(ListNode head) {

        if (head == null)
            return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = head;
        ListNode node = head.next;
        ListNode nextNode = node;

        while (nextNode != null){
            nextNode = node.next;
            insertSortOneRound(dummy, prev, node);
            node = nextNode;
            if (prev.next != node){
                prev = prev.next;
            }
        }

        return dummy.next;
    }

    private static void insertSortOneRound(ListNode dummy, ListNode prevNode ,ListNode node) {

        ListNode anode = dummy.next;
        ListNode prev = dummy;

        while (anode != prevNode.next){
            if (node.val < anode.val){
                prevNode.next = node.next;
                node.next = prev.next;
                prev.next = node;
                return;
            }
            prev = anode;
            anode = anode.next;
        }

        prevNode.next = node.next;
        node.next = prev.next;
        prev.next = node;

    }

    public static ListNode insertionSortListFinal(ListNode head) {

        if (head == null)
            return null;

        ListNode dummy = new ListNode(0);
        dummy.next = null;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode next = null;

        while (cur != null){

            next = cur.next;
            pre = dummy;

            while (pre.next != null && cur.val > pre.next.val){
                pre = pre.next;
            }

            cur.next = pre.next;
            pre.next = cur;
            cur = next;

        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new Node(-1);
        Problem147.addNode(head, 5, 0);
        Problem147.addNode(head, 3, 0);
        Problem147.addNode(head, 4, 0);
        Problem147.addNode(head, 0, 0);

        Problem147.printList(head);

        ListNode newHead = Problem147.insertionSortList(head);

        Problem147.printList(newHead);
    }

}
