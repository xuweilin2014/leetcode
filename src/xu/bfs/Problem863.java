package xu.bfs;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

import java.util.*;

/**
 * 此题求二叉树中，距离目标结点距离为K的所有结点。题目的关键是把二叉树转化为
 * 无向图，然后再利用BFS即可
 */

public class Problem863 {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if (root == null)
            return new ArrayList<>();

        Map<Integer, Set<Integer>> map = new HashMap<>();
        changeToGraph(root, map, null);
        int level = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        queue.add(target.val);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                visited.add(node);
                if (level == K){
                    ans.add(node);
                }
                for (int v : map.get(node)) {
                    if (!visited.contains(v))
                        queue.add(v);
                }
            }
            if (level == K)
                break;
            level++;
        }
        return ans;
    }

    private void changeToGraph(TreeNode cur, Map<Integer, Set<Integer>> map, TreeNode parent) {
        if (cur == null)
            return;

        Set<Integer> tmp = new HashSet<>();
        if (parent != null)
            tmp.add(parent.val);
        if (cur.right != null)
            tmp.add(cur.right.val);
        if (cur.left != null)
            tmp.add(cur.left.val);
        map.put(cur.val, tmp);
        changeToGraph(cur.left, map, cur);
        changeToGraph(cur.right, map, cur);
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4, null, null, null, null});
        System.out.println(new Problem863().distanceK(node, new TreeNode(5), 2));
    }
}
