package xu.backtracking;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.List;

public class Problem46 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        func(nums, list, 0, nums.length);
        return res;
    }

    private void func(int[] nums, List<Integer> list, int index, int length) {
        if (index == length){
            copyAndAdd(list);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])){
                list.add(nums[i]);
                func(nums, list, index + 1, length);
                list.remove(index);
            }
        }

    }

    private void copyAndAdd(List<Integer> list) {
        List<Integer> vals = new ArrayList<>();
        vals.addAll(list);
        res.add(vals);
    }

    public static void main(String[] args) {
        List<List<Integer>> permute = new Problem46().permute(new int[]{1, 2, 3});
        System.out.println(permute.size());
        for (List<Integer> list : permute) {
            System.out.println(list);
        }
    }
}
