package xu.linkedlist.problems;

/**
 * problem 83. Remove Duplicates from Sorted List
 */
public class Problem83{

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode p = head;
        ListNode pp = head.next;
        while (pp != null){
            if (p.val != pp.val){
                if (p.next == pp){
                    p = p.next;
                }else {
                    p.next = pp;
                    p = pp;
                }
            }
            pp = pp.next;
        }

        p.next = pp;
        return head;
    }

    public static void main(String[] args) {
        ListNode node = SinglyLinkedListUtil.buildLinkedList(new int[]{1, 1, 2, 3, 3});
        SinglyLinkedListUtil.printList(new Problem83().deleteDuplicates(node));
        node = SinglyLinkedListUtil.buildLinkedList(new int[]{1, 1, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4,4});
        SinglyLinkedListUtil.printList(new Problem83().deleteDuplicates(node));
    }

}
