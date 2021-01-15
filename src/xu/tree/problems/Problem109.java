package xu.tree.problems;

import xu.linkedlist.problems.ListNode;
import xu.linkedlist.problems.SinglyLinkedListUtil;

public class Problem109 {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;

        return func(head, null);
    }

    private TreeNode func(ListNode head, ListNode tail){
        if (head == tail || head == null)
            return null;
        if (head.next == tail)
            return new TreeNode(head.val);

        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail){
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = func(head, slow);
        root.right = func(slow.next, tail);
        return root;
    }

    public static void main(String[] args) {
        ListNode node = SinglyLinkedListUtil.buildLinkedList(new int[]{-10, -3, -1, 0, 5, 9, 10});
        TreeNode root = new Problem109().sortedListToBST(node);
        TreeUtil.printTree(root);
        System.out.println();
        node = SinglyLinkedListUtil.buildLinkedList(new int[]{-10, -3, 0, 5, 9});
        root = new Problem109().sortedListToBST(node);
        TreeUtil.printTree(root);
    }

}
