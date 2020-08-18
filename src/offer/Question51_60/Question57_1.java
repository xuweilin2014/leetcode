package offer.Question51_60;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Question57_1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
            if (map.containsKey(target - nums[i]) &&
                    map.get(target - nums[i]) != i){
                return new int[]{nums[i], target - nums[i]};
            }
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Question57_1().twoSum(new int[]{10, 20, 30, 31, 47, 60}, 40)));
    }

}
