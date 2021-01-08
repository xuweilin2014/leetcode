package xu.linkedlist.problems;

/**
 * problem 147. Insertion Sort List
 * 插入排序，思想比较直接，就是对每一个节点都遍历一次链表，找到插入位置，然后插入链表
 */
public class Problem147{

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode p = head.next;
        ListNode prev = head;
        while (p != null){
            if (p.val >= prev.val){
                p = p.next;
                prev = prev.next;
            }else {
                ListNode tmp = p.next;
                prev.next = p.next;
                insertOneRound(dummy, p);
                p = tmp;
            }
        }

        return dummy.next;
    }

    private void insertOneRound(ListNode dummy, ListNode node) {
        ListNode prev = dummy;
        while (prev.next != null){
            ListNode tmp = prev.next;
            if (node.val < prev.next.val){
                node.next = prev.next;
                prev.next = node;
                break;
            }
            prev = tmp;
        }

        if (prev.next == null){
            node.next = null;
            prev.next = node;
        }
    }


    public static void main(String[] args) {
        ListNode node = SinglyLinkedListUtil.buildLinkedList(new int[]{-1, 5, 3, 8, 0});
        SinglyLinkedListUtil.printList(new Problem147().insertionSortList(node));
        node = SinglyLinkedListUtil.buildLinkedList(new int[]{4,2,1,3});
        SinglyLinkedListUtil.printList(new Problem147().insertionSortList(node));
        node = SinglyLinkedListUtil.buildLinkedList(new int[]{4,3,2,1});
        SinglyLinkedListUtil.printList(new Problem147().insertionSortList(node));
    }

}
