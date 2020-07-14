package algorithm_analysis_and_design.reduce_and_conquer;

public class InsertSort {

    public static void main(String[] args) {
        int[] nums = new int[]{12,15,9,20,10,6};
        insertSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void insertSort(int[] nums){
        if (nums.length == 0 || nums.length == 1)
            return;

        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            int k = i;
            while (k > 0 && val < nums[k-1]){
                nums[k] = nums[k-1];
                k--;
            }

            nums[k] = val;
        }
    }

}
