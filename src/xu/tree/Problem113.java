package xu.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Problem113 {
    private List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return result;

        List<Integer> list = new ArrayList<>();
        func(root, 0, list, sum);
        return result;
    }

    private void func(TreeNode cur, int sum, List<Integer> list, int target) {
        if (cur == null)
            return;

        list.add(cur.val);
        sum += cur.val;
        if (sum == target){
            if (cur.left == null && cur.right == null)
                copyAndAdd(list);
        }
        func(cur.left, sum, list, target);
        func(cur.right,sum,list,target);
        list.remove(list.size() - 1);
    }

    private void copyAndAdd(List<Integer> list) {
        List<Integer> vals = new ArrayList<>();
        vals.addAll(list);
        result.add(vals);
    }

    public static void main(String[] args) {
        TreeNode cur = TreeUtil.buildTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1});
        List<List<Integer>> lists = new Problem113().pathSum(cur, 22);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
