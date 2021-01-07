package xu.linkedlist.problems;

/**
 * 160. Intersection of Two Linked Lists
 */
public class Problem160{

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB){
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }

        return curA;
    }

}
