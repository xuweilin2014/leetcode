package xu.linkedlist.problems;

/**
 * 92. Reverse Linked List II
 */

public class Problem92 extends SinglyLinkedListUtil{

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode beforeFirst = dummy;
        ListNode cur = head;
        int i = 1;
        while (i < m){
            beforeFirst = cur;
            cur = cur.next;
            i++;
        }

        ListNode prev = null;
        ListNode next;
        while ( i <= n){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            i++;
        }

        beforeFirst.next.next = cur;
        beforeFirst.next = prev;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        Problem92.addNode(head1, 2, 0);
        Problem92.addNode(head1, 3, 0);
        Problem92.addNode(head1, 4, 0);
        Problem92.addNode(head1, 5, 0);
        Problem92.addNode(head1, 6, 0);
        Problem92.addNode(head1, 7, 0);

        head1 = Problem92.reverseBetween(head1, 1, 7);

        Problem92.printList(head1);
    }

}
