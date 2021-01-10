package xu.linkedlist.problems;

/**
 * problem 86
 */
public class Problem86 {

    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return null;

        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;
        ListNode p = head;

        while (p != null){
            ListNode tmp = p.next;
            if (p.val >= x){
                p1.next = p;
                p1 = p;
            }else {
                p2.next = p;
                p2 = p;
            }
            p.next = null;
            p = tmp;
        }

        p2.next = dummy1.next;
        return dummy2.next;
    }

    public static void main(String[] args) {
        ListNode node = SinglyLinkedListUtil.buildLinkedList(new int[]{1, 4, 3, 2, 5, 2});
        SinglyLinkedListUtil.printList(new Problem86().partition(node, 3));
        node = SinglyLinkedListUtil.buildLinkedList(new int[]{1, 4, 3, 2, 5, 2});
        SinglyLinkedListUtil.printList(new Problem86().partition(node, 5));
        node = SinglyLinkedListUtil.buildLinkedList(new int[]{1, 4, 3, 0, 2, 5, 2});
        SinglyLinkedListUtil.printList(new Problem86().partition(node, 3));
        node = SinglyLinkedListUtil.buildLinkedList(new int[]{3,1,2});
        SinglyLinkedListUtil.printList(new Problem86().partition(node, 3));
    }
}
