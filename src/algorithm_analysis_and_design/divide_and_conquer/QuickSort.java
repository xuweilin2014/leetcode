package algorithm_analysis_and_design.divide_and_conquer;

public class QuickSort {

    public static void main(String[] args) {
        int[] vals = {23,13,35,6,19,-50,28};
        quickSort(vals);
        for (int i = 0; i < vals.length; i++) {
            System.out.print(vals[i] + " ");
        }
    }

    public static int partition(int[] nums, int left, int right){
        int axis = nums[left];
        int low = left;
        int high = right;

        while (low < high) {
            while (nums[high] >= axis && low < high) {
                high--;
            }

            if (low < high)
                nums[low] = nums[high];

            while (nums[low] <= axis && low < high) {
                low++;
            }

            if (low < high)
                nums[high] = nums[low];
        }

        nums[high] = axis;
        return high;
    }

    public static void doQuickSort(int[] nums, int left, int right){
        if (nums == null || nums.length == 0)
            return;

        if (left < right) {
            int p = partition(nums, left, right);
            doQuickSort(nums, left, p - 1);
            doQuickSort(nums, p + 1, right);
        }
    }

    public static void quickSort(int[] nums){
        doQuickSort(nums, 0, nums.length - 1);
    }

}
