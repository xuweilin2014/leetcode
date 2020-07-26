package xu.linkedlist;

/**
 * 24. Swap Nodes in Pairs
 */
public class Problem24 extends SinglyLinkedListUtil{

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode node = head;
        dummy.next = head;

        while (node != null){
            ListNode node1 = prev;
            ListNode node2 = node1.next;
            if (node2 == null){
                return dummy.next;
            }
            ListNode node3 = node2.next;
            if (node3 == null){
                return dummy.next;
            }
            swapPairs0(node1, node2, node3);
            prev = node2;
        }

        return dummy.next;
    }

    private static void swapPairs0(ListNode node1, ListNode node2, ListNode node3) {

        node1.next = node2.next;
        node2.next = node3.next;
        node3.next = node2;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        Problem24.addNode(head, 2,0);
        Problem24.addNode(head, 3,0);
        Problem24.addNode(head, 4,0);
        Problem24.addNode(head, 5,0);
        Problem24.addNode(head, 6,0);
        Problem24.addNode(head, 7,0);

        Problem24.printList(head);

        head = Problem24.swapPairs(head);
        Problem24.printList(head);
    }
}
