package xu.tree.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem894 {

    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> ans = new ArrayList<>();
        if (N % 2 == 0)
            return ans;
        if (N == 1){
            TreeNode root = new TreeNode(0);
            ans.add(root);
            return ans;
        }

        for (int counter = 1; counter < N; counter += 2) {
            List<TreeNode> left = allPossibleFBT(counter);
            List<TreeNode> right = allPossibleFBT(N - 1 - counter);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    ans.add(root);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        List<TreeNode> nodes = new Problem894().allPossibleFBT(7);
        for (TreeNode node : nodes) {
            TreeUtil.printTree(node);
            System.out.println();
        }
    }

}
