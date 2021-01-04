package xu.linkedlist.problems;

/**
 * 160. Intersection of Two Linked Lists
 */

public class Problem160 extends SinglyLinkedListUtil {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        if (headA == headB)
            return headA;

        int lenA = 0;
        int lenB = 0;
        ListNode curA = headA;
        ListNode curB = headB;

        while (curA != null){
            lenA++;
            curA = curA.next;
        }

        while (curB != null){
            lenB++;
            curB = curB.next;
        }

        curA = headA;
        curB = headB;
        if (lenA > lenB){
            for (int k = (lenA - lenB); k > 0; k--)
                curA = curA.next;
        }

        if (lenB > lenA){
            for (int k = (lenB - lenA); k > 0; k--)
                curB = curB.next;
        }

        while (curA != curB){
            curA = curA.next;
            curB = curB.next;
        }

        return curA;
    }

}
