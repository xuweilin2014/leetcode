package offer.question11_20.solutions;

import xu.linkedlist.problems.ListNode;

public class QSolution18_2 {

    /*
     * 删除链表中重复的结点
     */

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
