package xu.linkedlist.problems;

/**
 * problem 2:Add Two Numbers
 */
public class Problem2{

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return null;

        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int carry = 0;
        int sum = 0;
        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;
        while (cur1 != null && cur2 != null){
            sum = cur1.val + cur2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            ListNode tmp = new ListNode(sum);
            ans.next = tmp;
            ans = tmp;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        while (cur1 != null){
            sum = cur1.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            ListNode tmp = new ListNode(sum);
            ans.next = tmp;
            ans = tmp;
            cur1 = cur1.next;
        }

        while (cur2 != null){
            sum = cur2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            ListNode tmp = new ListNode(sum);
            ans.next = tmp;
            ans = tmp;
            cur2 = cur2.next;
        }

        if (carry != 0){
            ans.next = new ListNode(carry);
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = SinglyLinkedListUtil.buildLinkedList(new int[]{2, 4, 3});
        ListNode node2 = SinglyLinkedListUtil.buildLinkedList(new int[]{5, 6, 4});
        SinglyLinkedListUtil.printList(new Problem2().addTwoNumbers(node1, node2));
        node1 = SinglyLinkedListUtil.buildLinkedList(new int[]{0});
        node2 = SinglyLinkedListUtil.buildLinkedList(new int[]{0});
        SinglyLinkedListUtil.printList(new Problem2().addTwoNumbers(node1, node2));
        node1 = SinglyLinkedListUtil.buildLinkedList(new int[]{9,9,9,9,9,9,9});
        node2 = SinglyLinkedListUtil.buildLinkedList(new int[]{9,9,9,9});
        SinglyLinkedListUtil.printList(new Problem2().addTwoNumbers(node1, node2));
    }

}
