package xu.two_pointer.problems;

public class Problem209 {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int low = 0;
        int high = 0;
        int res = nums[0];
        int span = Integer.MAX_VALUE;

        while (low < nums.length){
            if (res >= s){
                span = Math.min(high - low + 1, span);
                res -= nums[low];
                low++;
            }else {
                high++;
                if (high == nums.length){
                    break;
                }
                res += nums[high];
            }
        }

        if (span == Integer.MAX_VALUE)
            return 0;

        return span;
    }

    public static void main(String[] args) {
        System.out.println(new Problem209().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

}
