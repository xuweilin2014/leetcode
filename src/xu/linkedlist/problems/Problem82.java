package xu.linkedlist.problems;

/**
 * problem 82. Remove Duplicates from Sorted List II
 */
public class Problem82{

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode p = head;
        ListNode pp = head.next;
        while (pp != null){
            if (p.val != pp.val){
                if (p.next == pp){
                    p = p.next;
                    prev = prev.next;
                }else {
                    prev.next = pp;
                    p = pp;
                }
            }
            pp = pp.next;
        }

        if (p.next != null && p.val == p.next.val)
            prev.next = null;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node = SinglyLinkedListUtil.buildLinkedList(new int[]{1, 2, 3, 3, 4, 4, 5, 5, 5});
        SinglyLinkedListUtil.printList(new Problem82().deleteDuplicates(node));
        node = SinglyLinkedListUtil.buildLinkedList(new int[]{1, 1, 2, 3, 3, 4, 4, 5});
        SinglyLinkedListUtil.printList(new Problem82().deleteDuplicates(node));
        node = SinglyLinkedListUtil.buildLinkedList(new int[]{1, 1, 2, 3, 3, 4, 5, 5, 5, 5});
        SinglyLinkedListUtil.printList(new Problem82().deleteDuplicates(node));
        node = SinglyLinkedListUtil.buildLinkedList(new int[]{1, 1, 2, 3, 3, 4});
        SinglyLinkedListUtil.printList(new Problem82().deleteDuplicates(node));
    }

}
