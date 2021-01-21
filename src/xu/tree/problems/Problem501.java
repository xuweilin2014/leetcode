package xu.tree.problems;

import xu.tree.problems.TreeNode;

import java.util.*;

public class Problem501 {

    private Map<Integer, Integer> map = new HashMap<>();
    private int max = 1;

    public int[] findMode(TreeNode root) {
        if (root == null)
            return new int[0];

        func(root);
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max){
                ans.add(entry.getKey());
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    private void func(TreeNode root) {
        if (root == null)
            return;

        if (!map.containsKey(root.val)){
            map.put(root.val, 1);
        }else {
            map.put(root.val, map.get(root.val) + 1);
            max = Math.max(max, map.get(root.val));
        }

        func(root.left);
        func(root.right);
    }


    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{2147483647});
        for (int i = 0; i < new Problem501().findMode(root).length; i++) {
            System.out.print(new Problem501().findMode(root)[i] + " ");
        }
    }
}
