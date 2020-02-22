package xu.bfs;

import xu.tree.TreeNode;
import xu.tree.TreeUtil;

import java.util.*;

public class Problem103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
        List<Integer> newList = new ArrayList<>();
        queue.add(root);
        int orient = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            newList.clear();
            stack.clear();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (orient == 1){
                    newList.add(node.val);
                }else{
                    stack.push(node.val);
                }
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }

            if (orient == 1)
                ans.add(new ArrayList<>(newList));
            else{
                List<Integer> tmp = new ArrayList<>();
                while (!stack.isEmpty()){
                    tmp.add(stack.pop());
                }
                ans.add(new ArrayList<>(tmp));
            }
            orient = orient == 1 ? 2 : 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(new Problem103().zigzagLevelOrder(node));
    }
}
