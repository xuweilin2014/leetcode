package xu.binary_search;

public class Problem153 {

    public int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        func(nums, 0, nums.length - 1);
        return nums[0];
    }

    private void func(int[] nums, int left, int right) {
        if (left >= right)
            return;

        int pivotal = nums[left];
        int low = left;
        int high = right;
        while (low < high){
            while (low < high && nums[high] >= pivotal)
                high--;
            if (low < high && nums[high] < pivotal)
                nums[low] = nums[high];

            while (low < high && nums[low] <= pivotal)
                low++;
            if (low < high && nums[low] > pivotal)
                nums[high] = nums[low];
        }
        nums[low] = pivotal;

        if (low != 0){
            func(nums, left, low - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problem153().findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(new Problem153().findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(new Problem153().findMin(new int[]{19,20,21,12,13,14,15,17,18}));
    }

}
