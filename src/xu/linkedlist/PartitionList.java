package xu.linkedlist;

/**
 * problem 86
 */

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode lNode = new ListNode(0);
        ListNode newHead = lNode;
        ListNode p = head;
        while (p != null){
            if (p.val < x){
                ListNode node = new ListNode(p.val);
                lNode.next = node;
                lNode = node;
            }
            p = p.next;
        }
        p = head;
        while (p!= null){
            if (p.val >= x){
                lNode.next = p;
                lNode = p;
            }
            p = p.next;
        }
        lNode.next = null;

        return newHead.next;
    }

    public ListNode partitionUltimate(ListNode head, int x){
        ListNode headBefore = new ListNode(0);
        ListNode headAfter = new ListNode(0);
        ListNode before = headBefore;
        ListNode after = headAfter;
        ListNode p = head;
        while (p != null){
            if (p.val < x){
                before.next = p;
                before = p;
            }else{
                after.next = p;
                after = p;
            }
            p = p.next;
        }
        before.next = headAfter.next;
        after.next = null;
        return headBefore.next;
    }

    private static class ListNode {
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

    public static void addNode(ListNode head, int val){
        ListNode node = new ListNode(val);
        node.next = null;
        if (head == null)
           head = node;
        ListNode p = head;
        while (p.next != null){
            p = p.next;
        }
        p.next = node;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        PartitionList.addNode(head,4);
        PartitionList.addNode(head,3);
        PartitionList.addNode(head,2);
        PartitionList.addNode(head,5);
        PartitionList.addNode(head,2);
        PartitionList.printList(head);
        head = new PartitionList().partitionUltimate(head,3);
        PartitionList.printList(head);
    }

}
