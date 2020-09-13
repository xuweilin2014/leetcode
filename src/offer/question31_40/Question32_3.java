package offer.question31_40;

import xu.tree.TreeNode;
import xu.tree.TreeUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Question32_3 {

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15});
        System.out.println(Print(node));
    }

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null)
            return new ArrayList<>();

        boolean left = false;
        List<TreeNode> queue = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()){
            List<TreeNode> newQueue = new ArrayList<>();
            ArrayList<Integer> line = new ArrayList<>();
            if (left){
                for (int i = queue.size() - 1; i >= 0; i--) {
                    line.add(queue.get(i).val);
                }
            }else{
                for (int i = 0; i < queue.size(); i++) {
                    line.add(queue.get(i).val);
                }
            }
            left = !left;
            res.add(line);

            // queue 始终按照正常顺序保存下一层的子节点，line则按照从左到右或者从右到左的顺序读取
            for (TreeNode node : queue) {
                if (node.left != null)
                    newQueue.add(node.left);
                if (node.right != null)
                    newQueue.add(node.right);
            }
            queue = newQueue;
        }

        return res;
    }

}
