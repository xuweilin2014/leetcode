package xu.linkedlist.problems;

public class Problem430 {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

    public Node flatten(Node head) {
        if (head == null)
            return null;

        Node cur = head;
        while (cur != null){
            if (cur.child != null){
                Node tmp = cur.next;
                cur.next = cur.child;
                cur.child.prev = cur;
                Node child = cur.child;

                while (child.next != null){
                    child = child.next;
                }

                child.next = tmp;
                if (tmp != null)
                    tmp.prev = child;

                cur.child = null;
            }
            cur = cur.next;
        }
        return head;
    }
}
