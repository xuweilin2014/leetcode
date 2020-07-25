package xu.linkedlist;

/**
 * @author xuwei_000
 */
public class SinglyLinkedList {

    public static void printList(ListNode p){
        while (p != null){
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static void addNode(ListNode head, int val, int type){
        ListNode node = null;
        if (type == 0){
            node = new ListNode(val);
        }else if (type == 1){
            node = new Node(val);
        }
        node.next = null;
        if (head == null)
            head = node;
        ListNode p = head;
        while (p.next != null){
            p = p.next;
        }
        p.next = node;
    }

    public static int getLength(ListNode head){
        ListNode p = head;
        int counter = 0;
        while (p != null){
            counter++;
            p = p.next;
        }
        return counter;
    }

    public static ListNode buildLinkedList(int[] vals){
        if (vals.length == 0)
            return null;

        ListNode head = new ListNode(vals[0]);
        ListNode p = head;
        for (int i = 1; i < vals.length; i++) {
            ListNode node = new ListNode(vals[i]);
            p.next = node;
            p = node;
        }

        p.next = null;
        return head;
    }

    // 获取链表倒数第二个结点
    public static ListNode getBeforeTail(ListNode head){
        if(head == null || head.next == null)
            return null;

        ListNode p = head;
        while (p.next.next != null){
            p = p.next;
        }
        return p;
    }
}
