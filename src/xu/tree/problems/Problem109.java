package xu.tree.problems;

import xu.linkedlist.ListNode;
import xu.linkedlist.SinglyLinkedListUtil;
import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

import java.util.ArrayList;
import java.util.List;

// 快慢指针来确定链表的中点
public class Problem109 {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;

        return build0(head, null);
    }

    private TreeNode build0(ListNode begin, ListNode end){
        if (begin == end)
            return null;

        if (begin.next == end)
            return new TreeNode(begin.val);

        ListNode slow = begin;
        ListNode fast = begin;
        while (fast != end && fast.next != end){
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = build0(begin, slow);
        root.right = build0(slow.next, end);

        return root;
    }

    public static void main(String[] args) {
        ListNode node = SinglyLinkedListUtil.buildLinkedList(new int[]{-10, -3, 0, 5, 9});
        TreeNode root = new Problem109().sortedListToBST(node);
        TreeUtil.printTree(root);

        node = SinglyLinkedListUtil.buildLinkedList(new int[]{1, 2, 3, 4});
        root = new Problem109().sortedListToBST(node);
        TreeUtil.printTree(root);
    }

}
