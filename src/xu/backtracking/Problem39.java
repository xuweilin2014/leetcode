package xu.backtracking;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;

public class Problem39 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0)
            return new ArrayList<>();

        dfs(candidates, 0, target, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] candidates, int val, int target, int sum, List<Integer> list) {
        if (sum > target)
            return;
        else if (sum == target){
            copyAndAdd(res, list);
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs(candidates,candidates[i], target, sum + candidates[i], list);
            list.remove(list.size() - 1);
        }
    }

    private void copyAndAdd(List<List<Integer>> res, List<Integer> list) {
        boolean flag = false;
        for (List<Integer> re : res) {
            if (re.size() != list.size())
                continue;
            else{
                for (int i = 0; i < re.size(); i++) {
                    if (!re.contains(list.get(i)))
                        flag = true;
                }
            }
            if (!flag)
        }

        List<Integer> vals = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            vals.add(list.get(i));
        }
        res.add(vals);
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Problem39().combinationSum(new int[]{2, 3, 6, 7}, 7);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
