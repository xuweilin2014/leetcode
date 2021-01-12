package xu.linkedlist.problems;

public class Problem234 {

    public boolean isPalindrome(ListNode head) {
       if (head == null || head.next == null)
           return true;

       ListNode slow = head;
       ListNode fast = head;
       ListNode prev = null;
       while (fast != null && fast.next != null){
           fast = fast.next.next;
           slow = slow.next;
       }

       prev = slow;
       slow = slow.next;
       while (slow != null){
           ListNode tmp = slow.next;
           slow.next = prev;
           prev = slow;
           slow = tmp;
       }

       ListNode p1 = head;
       ListNode p2 = prev;
       while (p1 != p2 && p1.next != p2){
           if (p1.val != p2.val)
               return false;
           p1 = p1.next;
           p2 = p2.next;
       }

       return p1.val == p2.val;
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
