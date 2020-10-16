package xu.array;

import xu.string.Problem49;

import java.util.Arrays;

public class Problem238 {

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int left = 1;
        int right = 1;

        for (int i = 0; i < nums.length; i++) {
            res[i] = left;
            left = left * nums[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = res[i] * right;
            right = right * nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Problem238().productExceptSelf(new int[]{1, 2, 3, 4, 5})));
    }

}
