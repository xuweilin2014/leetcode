package xu.array;

import java.util.Arrays;

public class Problem16 {

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 1, 2, 4}, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
           if (i > 0 && nums[i] == nums[i-1])
               continue;

           int aim = target - nums[i];
           int l = i + 1, r = nums.length - 1;
           while (l < r){
               if (minLen > getDistance(aim, nums[l], nums[r])){
                   minLen = getDistance(aim, nums[l], nums[r]);
                   sum = nums[i] + nums[l] + nums[r];
               }

               if (nums[l] + nums[r] == aim)
                   return sum;
               else if (nums[l] + nums[r] > aim){
                   r--;
               }else {
                   l++;
               }
           }
        }

        return sum;
    }

    private static int getDistance(int aim, int val1, int val2) {
        return Math.abs(aim - (val1 + val2));
    }

}
