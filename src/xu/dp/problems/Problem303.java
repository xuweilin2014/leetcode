package xu.dp.problems;

public class Problem303 {

    private long[] sums;

    public Problem303(int[] nums) {
        this.sums = new long[nums.length];
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }
    }

    public int sumRange(int i, int j) {
        return (int) (i == 0 ? sums[j] : sums[j] - sums[i - 1]);
    }

    public static void main(String[] args) {
        Problem303 arr = new Problem303(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(arr.sumRange(0, 2));
        System.out.println(arr.sumRange(2, 5));
        System.out.println(arr.sumRange(0, 5));
    }

}
