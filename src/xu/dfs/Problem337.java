package xu.dfs;

import xu.tree.TreeNode;
import xu.tree.TreeUtil;
import java.util.ArrayList;
import java.util.List;

public class Problem337 {

    private List<Integer> money = new ArrayList<>();
    private int maxMoney = 0;

    public int rob(TreeNode root) {
        if (root == null)
            return 0;

        money.add(0);money.add(0);
        dfs(root, -1, root.val);
        return maxMoney;
    }

    private void dfs(TreeNode root, int prevColor, int prevVal) {
        if (root == null)
            return;

        if (maxMoney < Math.max(money.get(0),money.get(1)))
            maxMoney = Math.max(money.get(0), money.get(1));

        for (int i = 1; i <= 2; i++) {
            if (prevColor != i)
                money.set(i - 1, money.get(i - 1) + root.val);
            dfs(root.left, i, root.val);
            dfs(root.right,i,root.val);
            if (prevColor != i)
                money.set(i - 1,money.get(i-1) - root.val);
        }
    }


    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{4,1,null,2,null,3,null});
        System.out.println(new Problem337().rob(node));
    }
}
