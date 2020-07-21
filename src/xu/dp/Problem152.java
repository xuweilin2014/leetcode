package xu.dp;

public class Problem152 {

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-2,0,-1}));
    }

    public static int maxProduct(int[] nums) {
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];
        min[0] = nums[0];
        max[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(max[i - 1] * nums[i], Math.max(min[i - 1] * nums[i], nums[i]));
            min[i] = Math.min(max[i - 1] * nums[i], Math.min(min[i - 1] * nums[i], nums[i]));
        }

        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < max.length; i++) {
            if (max[i] > maxVal)
                maxVal = max[i];
        }

        return maxVal;
    }

}
