package algorithm_analysis_and_design.sort;

public class MergeSort {

    public void mergeSort(int[] nums){
        MSort(nums, 0, nums.length - 1);
    }

    private void MSort(int[] nums, int begin, int end) {
        if (begin < end){
            int mid = (begin + end) / 2;
            MSort(nums, begin, mid);
            MSort(nums, mid + 1, end);
            merge(nums, begin, mid, end);
        }
    }

    private void merge(int[] nums, int begin, int mid, int end) {
        int[] temp = new int[end - begin + 1];
        int k = 0, i = begin, j = mid + 1;
        for (; i <= mid && j <= end;){
            if (nums[i] < nums[j])
                temp[k++] = nums[i++];
            else
                temp[k++] = nums[j++];
        }

        while (i <= mid){
            temp[k++] = nums[i++];
        }
        while (j <= end){
            temp[k++] = nums[j++];
        }

        for (int m = begin, n = 0; m <= end ; m++, n++) {
            nums[m] = temp[n];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{16,0,8,8,9,95,48,74,23,-8};
        new MergeSort().mergeSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

}
