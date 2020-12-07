package xu.tree.problems;

import java.util.*;

public class Problem429 {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null)
            return new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.add(root);
        int len = 1;

        while (!queue.isEmpty()){
            int counter = 0;
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                Node node = queue.poll();
                list.add(node.val);
                for (int j = 0; j < node.children.size(); j++) {
                    Node anode = node.children.get(j);
                    if (anode != null)
                        queue.add(anode);
                    counter++;
                }
            }
            res.add(list);
            len = counter;
        }

        return res;
    }


}
