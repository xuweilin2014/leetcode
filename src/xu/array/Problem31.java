package xu.array;

import xu.string.Problem3;

import java.util.Arrays;

/**
 * 从数组后面往前面倒着查找
 */
public class Problem31 {

    public void nextPermutation(int[] nums) {
        if (nums.length == 1)
            return;

        int len = nums.length;
        if (nums[len - 1] > nums[len - 2]) {
            swap(nums, len - 1, len - 2);
            return;
        }

        int p = len - 1;
        int prev = p - 1;
        while (prev >= 0 && nums[prev] >= nums[p]){
            prev--;
            p--;
        }

        if (prev < 0) {
            Arrays.sort(nums);
        }else {
            Arrays.sort(nums, p, nums.length);
            for (int i = p; i < nums.length; i++) {
                if (nums[i] > nums[prev]){
                    swap(nums, i, prev);
                    return;
                }
            }
        }
    }

    private void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        int[] ints = {5, 3, 2, 7, 4};
        new Problem31().nextPermutation(ints);
        System.out.println(Arrays.toString(ints));
        ints = new int[]{5, 3, 2, 4, 7};
        new Problem31().nextPermutation(ints);
        System.out.println(Arrays.toString(ints));
        ints = new int[]{2,7,5,4,3};
        new Problem31().nextPermutation(ints);
        System.out.println(Arrays.toString(ints));
    }

}
