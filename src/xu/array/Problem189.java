package xu.array;

import java.util.Arrays;

public class Problem189 {

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0)
            return;

        func(nums, 0, nums.length - 1);
        func(nums, 0, k - 1);
        func(nums, k, nums.length - 1);
    }

    private void func(int[] nums, int low, int high){
        int tmp = 0;
        for (int i = low; i <= (low + high) / 2; i++) {
            tmp = nums[i];
            nums[i] = nums[high - (i - low)];
            nums[high - (i - low)] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] val = new int[]{1,2,3,4,5,6,7};
        new Problem189().rotate(val, 3);
        System.out.println(Arrays.toString(val));

        val = new int[]{-1, -100, 3, 99};
        new Problem189().rotate(val, 2);
        System.out.println(Arrays.toString(val));
    }

}
