package xu.linkedlist.problems;

/**
 * 92. Reverse Linked List II
 */
public class Problem92{

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode p = dummy.next;
        int counter = 1;
        while (counter < m){
            prev = prev.next;
            p = p.next;
            counter++;
        }

        ListNode begin = p;
        p = p.next;
        while (counter < n){
            ListNode tmp = p.next;
            p.next = prev.next;
            prev.next = p;
            p = tmp;
            counter++;
        }
        begin.next = p;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node = SinglyLinkedListUtil.buildLinkedList(new int[]{1, 2, 3, 4, 5});
        SinglyLinkedListUtil.printList(new Problem92().reverseBetween(node, 2, 4));
        node = SinglyLinkedListUtil.buildLinkedList(new int[]{1, 2, 3, 4, 5});
        SinglyLinkedListUtil.printList(new Problem92().reverseBetween(node, 1, 4));
        node = SinglyLinkedListUtil.buildLinkedList(new int[]{1, 2, 3, 4, 5});
        SinglyLinkedListUtil.printList(new Problem92().reverseBetween(node, 1, 5));
    }

}
