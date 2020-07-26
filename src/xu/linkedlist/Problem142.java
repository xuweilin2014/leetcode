package xu.linkedlist;

/**
 * Problem 142 Linked List Cycle II Important
 */

public class Problem142 extends SinglyLinkedListUtil {

    public static ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;

        ListNode pf = head;
        ListNode ps = head;

        do{
            ps = ps.next;
            pf = pf.next;
            if (pf == null)
                return null;
            pf= pf.next;
            if (ps == pf)
                break;
        }while (pf != null);

        if (ps != pf)
            return null;
        else{
            ps = head;
            while (ps != pf){
                ps = ps.next;
                pf = pf.next;
            }
        }
        return ps;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        Problem83.addNode(head,2,0);
        Problem83.addNode(head,0,0);
        Problem83.addNode(head,4,0);

        /*ListNode p = head;
        ListNode target = head;
        int counter = 0;
        int pos = 1;
        while (p != null){
            if(p.next == null){
                p.next = target;
                break;
            }
            if (counter == pos){
                target = p;
            }
            p = p.next;
            counter++;
        }*/

        ListNode node = Problem142.detectCycle(head);
        System.out.println(node != null ? node.val : "无环");

    }

}
