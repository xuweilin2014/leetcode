package algorithm_analysis_and_design.reduce_and_conquer;

public class SelectMinK {

    public static void main(String[] args) {
        System.out.println(selectMinK(new int[]{23, 46, 0, 8, 11, 18}, 2));
    }

    public static int selectMinK(int[] nums, int k){
        return doSelectMinK(nums, 0, nums.length - 1, k);
    }

    public static int doSelectMinK(int[] nums, int left, int right, int k){
        int mid = partition(nums, left, right);
        if (k == mid + 1)
            return nums[mid];
        else if (k > mid + 1)
            return doSelectMinK(nums, mid + 1, right, k);
        else
            return doSelectMinK(nums, left, mid -1, k);
    }

    public static int partition(int[] nums, int left, int right){
        int pivot = nums[left];
        int low = left;
        int high = right;

        while (low < high){
            while (low < high && nums[high] >= pivot)
                high--;

            if (low < high)
                nums[low] = nums[high];

            while (low < high && nums[low] <= pivot)
                low++;

            if (low < high)
                nums[high] = nums[low];
        }

        nums[high] = pivot;
        return high;
    }

}
