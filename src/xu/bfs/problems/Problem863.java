package xu.bfs.problems;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

import java.util.*;

public class Problem863 {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if (root == null || target == null)
            return new ArrayList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();
        changeToGraph(root, map, null);
        List<Integer> ans = new ArrayList<>();
        List<Integer> visited = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(target.val);
        visited.add(target.val);
        int layer = 0;

        if (K == 0){
            ans.add(target.val);
            return ans;
        }

        while (!queue.isEmpty()){
            List<Integer> copy = new ArrayList<>();
            layer++;
            for (Integer node : queue) {
                List<Integer> vals = map.get(node);

                if (vals.size() > 0){
                    for (Integer val : vals) {
                        if (!visited.contains(val)){
                            copy.add(val);
                            visited.add(val);
                        }
                    }
                }
            }

            if (layer == K){
                ans.addAll(copy);
                break;
            }

            queue.clear();
            queue.addAll(copy);
        }

        return ans;
    }

    private void changeToGraph(TreeNode cur, Map<Integer, List<Integer>> map, TreeNode parent){
        if (cur == null)
            return;

        List<Integer> tmp = new ArrayList<>();
        if (parent != null)
            tmp.add(parent.val);
        if (cur.left != null)
            tmp.add(cur.left.val);
        if (cur.right != null)
            tmp.add(cur.right.val);

        map.put(cur.val, tmp);
        changeToGraph(cur.left, map, cur);
        changeToGraph(cur.right, map, cur);
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4, null, null, null, null});
        System.out.println(new Problem863().distanceK(node, new TreeNode(5), 2));
    }

}
