package xu.linkedlist;

/**
 * 445. Add Two Numbers II
 */
public class Problem445 extends SinglyLinkedListUtil{

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 == null ? l2 : l1;

        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode dummy = new ListNode(0);
        ListNode node1 = l1, node2 = l2;
        long nextVal = 0;
        long val = 0;

        while (node1 != null && node2 != null){
            val = node1.val + node2.val + nextVal;
            nextVal = val / 10;
            val = val % 10;
            ListNode anode = new ListNode((int) val);
            anode.next = dummy.next;
            dummy.next = anode;
            node1 = node1.next;
            node2 = node2.next;
            val = 0;
        }

        while (node1 != null){
            val = node1.val + nextVal;
            nextVal = val / 10;
            val = val % 10;
            ListNode anode = new ListNode((int) val);
            anode.next = dummy.next;
            dummy.next = anode;
            node1 = node1.next;
            val = 0;
        }

        while (node2 != null){
            val = node2.val + nextVal;
            nextVal = val / 10;
            val = val % 10;
            ListNode anode = new ListNode((int) val);
            anode.next = dummy.next;
            dummy.next = anode;
            node2 = node2.next;
            val = 0;
        }

        if (nextVal != 0){
            ListNode anode = new ListNode((int) nextVal);
            anode.next = dummy.next;
            dummy.next = anode;
        }

        return dummy.next;
    }

    public static ListNode reverseList(ListNode head){
        ListNode prev = null, cur = head, next;

        while (cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        ListNode l2 = new ListNode(5);
        ListNode HEAD = Problem445.addTwoNumbers(l1, l2);
        Problem445.printList(HEAD);
    }

}
