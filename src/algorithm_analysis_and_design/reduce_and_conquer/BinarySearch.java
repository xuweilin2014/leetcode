package algorithm_analysis_and_design.reduce_and_conquer;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{7}, 7));
    }

    public static int binarySearch(int[] nums, int target){
        Arrays.sort(nums);
        int low = 0, high = nums.length - 1;
        while (low <= high){
            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return mid;
            else if (target < nums[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }

        return -1;
    }

}
