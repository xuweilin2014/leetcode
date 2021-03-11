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
        ListNode head = Question18_2.buildLinkedList(new int[]{1,3, 3, 4, 4, 5});
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

        head = Question18_2.buildLinkedList(new int[]{1,1,1,1,1,1});
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
        ListNode node = head;
        boolean isDuplicate;
        while (node != null){
            isDuplicate = false;
            while (node.next != null && node.next.val == node.val) {
                node = node.next;
                isDuplicate = true;
            }

            if (isDuplicate){
                node = node.next;
                prev.next = node;
            }else{
                if (node.next != null && node.next.val > node.val){
                    prev = node;
                }

                node = node.next;
            }
        }

        return dummy.next;
    }



}
