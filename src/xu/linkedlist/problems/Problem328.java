package xu.linkedlist.problems;

/**
 * 328. Odd Even Linked List
 */
public class Problem328 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummyOdd = new ListNode(0);
        ListNode dummyEven = new ListNode(0);
        ListNode p1 = dummyOdd;
        ListNode p2 = dummyEven;
        ListNode cur = head;
        int counter = 1;

        while (cur != null){
            ListNode tmp = cur.next;
            if (counter % 2 == 0){
                p2.next = cur;
                p2 = cur;
            }else {
                p1.next = cur;
                p1 = cur;
            }
            cur.next = null;
            counter++;
            cur = tmp;
        }

        p1.next = dummyEven.next;
        return dummyOdd.next;
    }

    public static void main(String[] args) {
        ListNode node = SinglyLinkedListUtil.buildLinkedList(new int[]{1, 2, 3, 4, 5});
        SinglyLinkedListUtil.printList(new Problem328().oddEvenList(node));
        node = SinglyLinkedListUtil.buildLinkedList(new int[]{2,1,3,5,6,4,7});
        SinglyLinkedListUtil.printList(new Problem328().oddEvenList(node));
    }

}
