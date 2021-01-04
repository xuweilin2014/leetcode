package xu.linkedlist.problems;

public class Problem234 {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode prev = slow;
        slow = slow.next;
        while (slow != null){
            ListNode tmp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = tmp;
        }

        ListNode last = prev;
        ListNode first = head;
        while (last != first && first.next != last){
            if (last.val != first.val)
                return false;
            last = last.next;
            first = first.next;
        }

        if (first.next == last)
            return first.val == last.val;

        return true;
    }

    public static void main(String[] args) {
        ListNode node = SinglyLinkedListUtil.buildLinkedList(new int[]{1, 2, 4, 5, 2, 1});
        System.out.println(new Problem234().isPalindrome(node));
        node = SinglyLinkedListUtil.buildLinkedList(new int[]{1, 2, 3, 3, 2, 1});
        System.out.println(new Problem234().isPalindrome(node));
        node = SinglyLinkedListUtil.buildLinkedList(new int[]{1, 2, 3, 2, 1});
        System.out.println(new Problem234().isPalindrome(node));
    }

}
