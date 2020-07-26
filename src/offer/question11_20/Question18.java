package offer.question11_20;

import xu.linkedlist.ListNode;


import java.util.List;

/**
 * 此题即在O(1)的时间内删除链表中的一个结点，需要分情况讨论：
 * 1.链表中有多个节点，需要删除中间节点时 O(1)
 * 2.链表中有多个节点，需要删除尾节点时  O(N)
 * 除此之外，还有一种特殊情况：
 * 3.链表中只有一个节点，需要删除这个头节点/尾节点
 */
public class Question18{

    public static void main(String[] args) {
        ListNode head = new ListNode(4);

    }

    public static void deleteNode(ListNode head, ListNode target){
        if (head == null || target == null)
            return;

        // 链表中有多个节点，删除中间节点
        if (target.next != null){
            target.val = target.next.val;
            target.next = target.next.next;

        // 链表中有一个结点，删除头结点/尾结点
        }else if (head.next == null){
            head = null;
            target = null;

        // 链表中有多个节点，删除尾节点
        }else{
            ListNode node = head;
            while (node.next != target){
                node = node.next;
            }

            node.next = null;
        }
    }

}
