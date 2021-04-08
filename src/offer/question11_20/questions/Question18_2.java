package offer.question11_20.questions;

import xu.linkedlist.problems.ListNode;
import xu.linkedlist.problems.SinglyLinkedListUtil;

/**
 * 删除链表中重复节点
 *
 * 下面的解法可以参考不需要进行修改
 */
public class Question18_2 extends SinglyLinkedListUtil {

    public static void main(String[] args) {
        ListNode head = Question18_2.buildLinkedList(new int[]{1,2,3,3,4,4,5});
        Question18_2.printList(head);
        head = Question18_2.deleteDuplication(head);
        Question18_2.printList(head);

        head = Question18_2.buildLinkedList(new int[]{1,1,3, 3, 4, 4, 5,5});
        Question18_2.printList(head);
        head = Question18_2.deleteDuplication(head);
        Question18_2.printList(head);

        head = Question18_2.buildLinkedList(new int[]{1,1,1,3, 3, 4, 4, 5});
        Question18_2.printList(head);
        head = Question18_2.deleteDuplication(head);
        Question18_2.printList(head);

        head = Question18_2.buildLinkedList(new int[]{1,3, 3, 4, 4, 5,5,5});
        Question18_2.printList(head);
        head = Question18_2.deleteDuplication(head);
        Question18_2.printList(head);

        head = Question18_2.buildLinkedList(new int[]{1,1,1,1,1,1,2,2,2});
        Question18_2.printList(head);
        head = Question18_2.deleteDuplication(head);
        Question18_2.printList(head);
    }

    public static ListNode deleteDuplication(ListNode head){
        if (head == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode p1 = head;
        ListNode p2;

        while (p1 != null){
            boolean flag = false;
            p2 = p1.next;

            while (p2 != null && p1.val == p2.val) {
                p2 = p2.next;
                flag = true;
            }

            if (!flag){
                prev = p1;
            }
            prev.next = p2;
            p1 = p2;
        }

        return dummy.next;
    }



}
