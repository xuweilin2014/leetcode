package xu.array;

/**
 * 搜索旋转排序数组
 *
 * 将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。此时有序部分用二分法查找。
 * 无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.
 */
public class Problem33 {

    public static void main(String[] args) {
        System.out.println(search(new int[]{4}, 4));
    }

    public static int search(int[] nums, int target) {
        return doSearch(nums, target, 0, nums.length - 1);
    }

    public static int doSearch(int[] nums, int target, int left, int right){
        int index1 = -1, index2 = -1;
        if (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] >= nums[left]){
                if (target >= nums[left] && target <= nums[mid]){
                    index1 = binarySearch(nums, target, left, mid);
                }else {
                    index1 = doSearch(nums, target, mid + 1, right);
                }
            }else if (nums[mid] <= nums[right]){
                if (target <= nums[right] && target >= nums[mid]){
                    index2 = binarySearch(nums, target, mid, right);
                }else{
                    index2 = doSearch(nums, target, left, mid - 1);
                }
            }
        }

        if (index1 != -1)
            return index1;

        if (index2 != -1)
            return index2;

        return -1;
    }

    private static int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return -1;
    }

}
