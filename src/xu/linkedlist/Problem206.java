package xu.linkedlist;

import com.sun.corba.se.impl.naming.namingutil.CorbalocURL;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * 206. Reverse Linked List
 */
public class Problem206 extends SinglyLinkedList{

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = null;
        ListNode cur = head;
        ListNode next;

        while (cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

}
