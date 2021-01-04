package xu.linkedlist.problems;

//problem 21

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)  return l2;
        if(l2 == null)  return l1;

        ListNode p = new ListNode(0);
        ListNode head = p;
        p.next = l1;

        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                p.next = l1;
                p = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                p = l2;
                l2 = l2.next;
            }
        }

        p.next = l1 == null ? l2 : l1;

        return head.next;
    }



     public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
         }
     }

    public static void printList(ListNode p){
        while (p != null){
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }
}
