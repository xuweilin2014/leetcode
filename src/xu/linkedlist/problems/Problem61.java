package xu.linkedlist.problems;

/**
 *  Problem 61 Rotate List
 *  将链表进行旋转，其实本质上是将尾部向前数第K个元素作为头，原来的头接到原来的尾上
 */
public class Problem61 extends SinglyLinkedListUtil {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        int length = 0;
        for (ListNode cur = head; cur != null; cur = cur.next){
            length++;
        }
        k = k % length;
        if (k == 0)
            return head;

        int target = length - k;
        int counter = 0;
        ListNode cur = head;
        while (counter < target - 1){
            cur = cur.next;
            counter++;
        }
        ListNode p = cur.next;
        ListNode pp = cur.next;
        cur.next = null;
        for (; pp.next != null; pp = pp.next){
        }
        pp.next = head;
        return p;
    }

    public static void main(String[] args) {
        ListNode node = SinglyLinkedListUtil.buildLinkedList(new int[]{1, 2, 3, 4, 5});
        SinglyLinkedListUtil.printList(new Problem61().rotateRight(node, 2));
        node = SinglyLinkedListUtil.buildLinkedList(new int[]{1, 2, 3, 4, 5});
        SinglyLinkedListUtil.printList(new Problem61().rotateRight(node, 5));
        node = SinglyLinkedListUtil.buildLinkedList(new int[]{0,1,2});
        SinglyLinkedListUtil.printList(new Problem61().rotateRight(node, 4));
    }
}
