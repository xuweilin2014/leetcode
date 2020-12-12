package xu.binary_search;

public class Problem81 {

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;
        if (nums.length == 1)
            return nums[0] == target;

        return find0(nums, 0, nums.length - 1, target);
    }

    private boolean find0(int[] nums, int left, int right, int target){
        if (left == right)
            return nums[left] == target;

        int mid = (left + right) / 2;

        if (nums[mid] == target)
            return true;

        if (nums[mid] == nums[left] && nums[mid] == nums[right]){
            return find0(nums, left + 1, right, target);
        }else if (nums[mid] >= nums[left]){
            if (nums[mid] > target && target >= nums[left]){
                return find0(nums, left, mid - 1, target);
            }else {
                return find0(nums, mid + 1, right, target);
            }
        } else if (nums[mid] <= nums[right]){
            if (nums[mid] < target && target <= nums[right]){
                return find0(nums, mid + 1, right, target);
            }else {
                return find0(nums, left, mid - 1, target);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Problem81().search(new int[]{3, 3, 5, 6, 7, 8, 9, 1, 2}, 3));
        System.out.println(new Problem81().search(new int[]{3, 3, 5, 6, 7, 8, 9, 1, 2}, 6));
        System.out.println(new Problem81().search(new int[]{3, 3, 5, 6, 7, 8, 9, 1, 2}, 1));
        System.out.println(new Problem81().search(new int[]{3, 3, 5, 6, 7, 8, 9, 1, 2}, 2));
        System.out.println(new Problem81().search(new int[]{3, 3, 5, 6, 7, 8, 9, 1, 2}, 2));
        System.out.println(new Problem81().search(new int[]{7, 8, 9, 1, 2, 3, 3, 5, 6}, 1));
        System.out.println(new Problem81().search(new int[]{7, 8, 9, 1, 2, 3, 3, 5, 6}, 9));
        System.out.println(new Problem81().search(new int[]{7, 8, 9, 1, 2, 3, 3, 5, 6}, 6));
        System.out.println(new Problem81().search(new int[]{7, 8, 9, 1, 2, 3, 3, 5, 6}, 3));
        System.out.println(new Problem81().search(new int[]{7, 8, 9, 1, 2, 3, 3, 5, 6}, 4));
        System.out.println(new Problem81().search(new int[]{1, 1, 0, 1, 1, 1, 1, 1}, 4));
        System.out.println(new Problem81().search(new int[]{1, 1, 0, 1, 1, 1, 1, 1}, 1));
        System.out.println(new Problem81().search(new int[]{1, 1, 0, 1, 1, 1, 1, 1}, 0));
    }

}
