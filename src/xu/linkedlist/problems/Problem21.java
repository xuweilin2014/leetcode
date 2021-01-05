package xu.linkedlist.problems;

/**
 * 21.合并两个有序链表
 * 这道题目很简单，但是一定要多写几遍，要写的很熟练
 */
public class Problem21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p = dummy;
        while (p1 != null && p2 != null){
            ListNode tmp = null;
            if (p1.val >= p2.val){
                tmp = p2;
                p2 = p2.next;
            }else {
                tmp = p1;
                p1 = p1.next;
            }
            p.next = tmp;
            p = tmp;
        }

        if (p1 != null)
            p.next = p1;
        if (p2 != null)
            p.next = p2;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = SinglyLinkedListUtil.buildLinkedList(new int[]{1, 2, 4});
        ListNode node2 = SinglyLinkedListUtil.buildLinkedList(new int[]{1, 3, 4});
        ListNode node = new Problem21().mergeTwoLists(node1, node2);
        SinglyLinkedListUtil.printList(node);
    }
}
