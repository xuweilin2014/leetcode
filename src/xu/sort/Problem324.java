package xu.sort;

import java.util.Arrays;

public class Problem324 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int left = nums.length / 2;
        int right = nums.length - 1;
        if (nums.length % 2 == 0){
            left -= 1;
        }
        int[] vals = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0){
                vals[i] = nums[left--];
            }else{
                vals[i] = nums[right--];
            }
        }
        for (int i = 0; i < vals.length; i++) {
            nums[i] = vals[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        new Problem324().wiggleSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
