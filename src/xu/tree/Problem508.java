package xu.tree;

import com.sun.org.apache.regexp.internal.RE;

import java.util.*;

public class Problem508 {
    private int maxCount = 0;
    private List<Integer> list = new ArrayList<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null)
            return new int[0];

        HashMap<Integer, Integer> subtrreeSum = new HashMap<>();
        func(root, subtrreeSum, 0);
        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }

    private int func(TreeNode root, HashMap<Integer, Integer> subtrreeSum, int sum) {
        if (root == null)
            return 0;

        int left = func(root.left, subtrreeSum, sum);
        int right = func(root.right, subtrreeSum, sum);

        sum = root.val + left + right;
        int counter = 0;
        if (!subtrreeSum.containsKey(sum)){
            counter = 1;
            subtrreeSum.put(sum, counter);
        }else{
            counter = subtrreeSum.get(sum);
            subtrreeSum.put(sum, ++counter);
        }

        if (counter == maxCount){
            list.add(sum);
        }else if (counter > maxCount){
            list.clear();
            list.add(sum);
            maxCount = counter;
        }

        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{5,2,-3});
        int[] frequentTreeSum = new Problem508().findFrequentTreeSum(root);
        System.out.println(Arrays.toString(frequentTreeSum));
    }
}
