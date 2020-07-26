package xu.linkedlist;

public class Problem1290 extends SinglyLinkedListUtil{

    public static int getDecimalValue(ListNode head) {
        if (head.next == null)
            return head.val;

        ListNode cur = reverseList(head);
        long base = 1;
        long sum = 0;

        while (cur != null){
            sum += cur.val * base;
            cur = cur.next;
            base *= 2;
        }

        return (int) sum;
    }

    public static ListNode reverseList(ListNode head) {
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

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        Problem1290.addNode(head, 1, 0);
        Problem1290.addNode(head, 0, 0);
        Problem1290.addNode(head, 1, 0);

        System.out.println(Problem1290.getDecimalValue(head));
    }

}
