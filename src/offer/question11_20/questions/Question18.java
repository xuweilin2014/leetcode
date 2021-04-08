package offer.question11_20.questions;

import offer.question1_10.questions.Question8;
import xu.linkedlist.problems.ListNode;
import xu.linkedlist.problems.SinglyLinkedListUtil;


public class Question18{

    public static void main(String[] args) {
        ListNode head = SinglyLinkedListUtil.buildLinkedList(new int[]{2});
        ListNode node = SinglyLinkedListUtil.getNode(head, 2);
        SinglyLinkedListUtil.printList(new Question18().deleteNode(head, node));
    }

    public ListNode deleteNode(ListNode head, ListNode val){
        if (head == null)
            return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        if (val.next == null){
            ListNode p = dummy;
            while (p.next != val && p.next != null){
                p = p.next;
            }
            if (p.next == val){
                p.next = null;
            }
        }else {
            ListNode pnext = val.next;
            val.val = pnext.val;
            val.next = pnext.next;
        }

        return dummy.next;
    }

}
