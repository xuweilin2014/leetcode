package xu.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 使用双指针，时间复杂度为 O(n^2)
 */
public class Problem15 {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                continue;

            if (i > 0 && nums[i] == nums[i-1])
                continue;

            int l = i + 1, r = nums.length - 1;
            int target = -nums[i];
            while (l < r){
                if (nums[l] + nums[r] == target){
                    List<Integer> arr = new ArrayList<>();
                    arr.add(nums[l]);
                    arr.add(nums[r]);
                    arr.add(nums[i]);
                    res.add(arr);
                    l++;
                    r--;

                    while (l < nums.length && nums[l] == nums[l-1])
                        l++;

                    while (r > l && r < nums.length - 1 && nums[r] == nums[r+1])
                        r--;
                }else if (nums[l] + nums[r] < target){
                    l++;
                }else{
                    r--;
                }
            }
        }

        return res;
    }

}
