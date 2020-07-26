package offer.question21_30;

import xu.linkedlist.ListNode;
import xu.linkedlist.SinglyLinkedListUtil;

/**
 * 找出链表中环的入口节点分为以下两个步骤：
 * 1.通过快、慢两个指针判断链表中是否有环
 * 2.用一个新指针从 head 节点开始前进，同时慢指针从相遇的节点开始同步前进，相遇节点即为入口
 */
public class Question23 {

    public static void main(String[] args) {
        ListNode head = SinglyLinkedListUtil.buildLinkedList(new int[]{1,2});
        ListNode node = SinglyLinkedListUtil.getNode(head, 2);
        node.next = head;
        System.out.println(EntryNodeOfLoop(head));
    }

    public static ListNode EntryNodeOfLoop(ListNode pHead){
        ListNode fast = pHead;
        ListNode slow = pHead;

        do{
            if (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
        }while (fast != null && fast.next != null && slow != fast);

        if (fast == null || fast.next == null)
            return null;

        ListNode ptr = pHead;
        while (ptr != slow){
            ptr = ptr.next;
            slow = slow.next;
        }

        return ptr;
    }

}
