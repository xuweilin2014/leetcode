package xu.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem18 {

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{-3,-1,1,1,1,3}, 0));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && target - nums[i] < 0)
                continue;
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int aim = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > 0 && aim - nums[j] < 0)
                    continue;
                if (j > i + 1 && nums[j] == nums[j-1])
                    continue;
                int key = aim - nums[j];
                int l = j + 1, r = nums.length - 1;
                while (l < r){
                    if (nums[l] + nums[r] == key){
                        List<Integer> arr = new ArrayList<>();
                        arr.add(nums[l]);
                        arr.add(nums[r]);
                        arr.add(nums[i]);
                        arr.add(nums[j]);
                        res.add(arr);

                        l++;
                        r--;
                        while (l < r && nums[l] == nums[l-1])
                            l++;
                        while (r > l && r < nums.length - 1 && nums[r] == nums[r+1])
                            r--;
                    }else if (nums[l] + nums[r] > key){
                        r--;
                    }else {
                        l++;
                    }
                }
            }
        }

        return res;
    }

}
