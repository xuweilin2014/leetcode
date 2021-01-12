package xu.linkedlist.problems;

public class Problem148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        int length = 0;
        ListNode cur = head;
        while (cur != null){
            length++;
            cur = cur.next;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (int inv = 1; inv < length; inv = inv * 2){
            ListNode prev = dummy;
            cur = prev.next;
            while (cur != null){
                ListNode head1 = cur;
                for (int i = 1; i < inv && cur.next != null; i++, cur = cur.next){
                }
                ListNode head2 = cur.next;
                cur.next = null;
                cur = head2;
                for (int i = 1; i < inv && cur != null && cur.next != null; i++, cur = cur.next){
                }
                ListNode tmp = null;
                if (cur != null) {
                    tmp = cur.next;
                    cur.next = null;
                }
                prev.next = merge(head1, head2);
                while (prev.next != null){
                    prev = prev.next;
                }
                cur = tmp;
            }
        }

        return dummy.next;
    }

    private ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode p1 = head1;
        ListNode p2 = head2;
        while (p1 != null && p2 != null){
            if (p1.val < p2.val){
                cur.next = p1;
                cur = p1;
                p1 = p1.next;
            }else {
                cur.next = p2;
                cur = p2;
                p2 = p2.next;
            }
        }

        while (p1 != null){
            cur.next = p1;
            cur = p1;
            p1 = p1.next;
        }

        while (p2 != null){
            cur.next = p2;
            cur = p2;
            p2 = p2.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = SinglyLinkedListUtil.buildLinkedList(new int[]{8,5,12,4});
        SinglyLinkedListUtil.printList(new Problem148().sortList(head));
        head = SinglyLinkedListUtil.buildLinkedList(new int[]{-1,5,3,4,0});
        SinglyLinkedListUtil.printList(new Problem148().sortList(head));
    }
}
