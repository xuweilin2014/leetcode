package xu.tree;

public class Problem117 {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        if (root == null)
            return null;

        root.next = null;
        Node start = root.left == null ? root.right : root.left;
        Node lastLayerCur = root;
        Node lastLayerPrev = root;
        Node prev = null;
        while (start != null){
            start = null;
            boolean flag = false;
            while (lastLayerCur != null) {
                if (lastLayerPrev != lastLayerCur && prev != null){
                    if (lastLayerCur.left != null)
                        prev.next = lastLayerCur.left;
                    else if (lastLayerCur.right != null)
                        prev.next = lastLayerCur.right;
                }
                if (lastLayerCur.left != null && lastLayerCur.right != null){
                    lastLayerCur.left.next = lastLayerCur.right;
                    prev = lastLayerCur.right;
                    if (!flag){
                        flag = true;
                        start = lastLayerCur.left;
                    }
                }else if (lastLayerCur.left != null || lastLayerCur.right != null){
                    prev = lastLayerCur.right == null ? lastLayerCur.left : lastLayerCur.right;
                    if (!flag){
                        flag = true;
                        start = prev;
                    }
                }
                lastLayerPrev = lastLayerCur;
                lastLayerCur = lastLayerCur.next;
            }
            lastLayerCur = start;
            lastLayerPrev = start;
            prev = null;
        }
        return root;
    }

    public Node funcFinal(Node root){
        Node head = root;
        Node prev = null;
        Node cur = null;

        while (head != null){
            prev = null;
            cur = head;
            head = null;
            while (cur != null){
                if (cur.left != null){
                    if (prev == null){
                        head = cur.left;
                    }else{
                        prev.next = cur.left;
                    }
                    prev = cur.left;
                }
                if (cur.right != null){
                    if (prev == null){
                        head = cur.right;
                    }else{
                        prev.next = cur.right;
                    }
                    prev = cur.right;
                }
                cur = cur.next;
            }
        }

        return root;
    }
}
