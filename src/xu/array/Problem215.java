package xu.array;

import java.util.Arrays;

public class Problem215 {

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{-1,2,0}, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        int index = doFind(nums, 0, nums.length - 1, k);
        return nums[index];
    }

    public static int doFind(int[] nums, int left, int right, int k){
        int p = 0, lp = 0, rp = 0;
        p = partition(nums, left, right);
        if (nums.length - p == k) {
            return p;
        } else if (nums.length - p < k) {
            lp = doFind(nums, left, p - 1, k);
        } else if (nums.length - p > k) {
            rp = doFind(nums, p + 1, right, k);
        }

        if (nums.length - lp == k)
            return lp;
        else
            return rp;
    }

    public static int partition(int[] nums, int left, int right){
        int axis = nums[left];
        int low = left;
        int high = right;

        while (low < high){
            while (nums[high] >= axis && low < high)
                high--;

            if (low < high)
                nums[low] = nums[high];

            while (nums[low] <= axis && low < high)
                low++;

            if (low < high)
                nums[high] = nums[low];
        }
        nums[high] = axis;

        return high;
    }

}
