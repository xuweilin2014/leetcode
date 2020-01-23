package xu.linkedlist;

public class Problem2 extends SinglyLinkedList {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 == null ? l2 : l1;

        ListNode dummy = new ListNode(0);
        ListNode last = dummy;
        ListNode node1 = l1, node2 = l2;
        long nextVal = 0;
        long val = 0;

        while (node1 != null && node2 != null){
            val = node1.val + node2.val + nextVal;
            nextVal = val / 10;
            val = val % 10;
            ListNode anode = new ListNode((int) val);
            last.next = anode;
            anode.next = null;
            last = anode;
            node1 = node1.next;
            node2 = node2.next;
            val = 0;
        }

        while (node1 != null){
            val = node1.val + nextVal;
            nextVal = val / 10;
            val = val % 10;
            ListNode anode = new ListNode((int) val);
            last.next = anode;
            anode.next = null;
            last = anode;
            node1 = node1.next;
            val = 0;
        }

        while (node2 != null){
            val = node2.val + nextVal;
            nextVal = val / 10;
            val = val % 10;
            ListNode anode = new ListNode((int) val);
            last.next = anode;
            anode.next = null;
            last = anode;
            node2 = node2.next;
            val = 0;
        }

        if (nextVal != 0){
            ListNode anode = new ListNode((int) nextVal);
            last.next = anode;
            anode.next = null;
            last = anode;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        /*Problem445.addNode(l1, 2, 0);
        Problem445.addNode(l1, 4, 0);
        Problem445.addNode(l1, 3, 0);*/

        ListNode l2 = new ListNode(5);
        /*Problem445.addNode(l2, 6, 0);
        Problem445.addNode(l2, 4, 0);*/

        ListNode HEAD = Problem2.addTwoNumbers(l1, l2);
        Problem2.printList(HEAD);
    }

}
