package xu.binary_search;


public class Problem162 {

    public int findPeakElement(int[] nums) {
        if (nums.length == 1)
            return 0;

        return doFind(nums, 0, nums.length - 1);
    }

    private int doFind(int[] nums, int left, int right) {
        int mid = (left + right) / 2;
        boolean midR = false;
        boolean midL = false;

        if (mid + 1 > right || nums[mid] > nums[mid + 1])
            midR = true;
        if (mid - 1 < left || nums[mid] > nums[mid - 1])
            midL = true;

        if (midR && midL)
            return mid;
        else if (!midR)
            return doFind(nums, mid + 1, right);
        else
            return doFind(nums, left, mid - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Problem162().findPeakElement(new int[]{1, 2, 8, 4, 3, 2, 1}));
        System.out.println(new Problem162().findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
        System.out.println(new Problem162().findPeakElement(new int[]{1, 1, 1, 3, 4, 6, 7}));
        System.out.println(new Problem162().findPeakElement(new int[]{5,3,2,1}));

    }


}
