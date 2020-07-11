package algorithm_analysis_and_design.divide_and_conquer;


/**
 * 使用分治法来解决最大字段和问题
 */
public class MaxSubSum {

    public static void main(String[] args) {
        System.out.println(maxSum(new int[]{-20}, 0, 0));
    }

    public static int maxSum(int[] vals, int left, int right){
        if (left == right)
            return vals[left];

        int center = (left + right) / 2;
        int leftSum = maxSum(vals, left, center);
        int rightSum = maxSum(vals, center + 1, right);

        int lmax = Integer.MIN_VALUE;
        int s = 0;
        for (int i = center; i >= left; i--){
            s += vals[i];
            if (s > lmax)
                lmax = s;
        }

        int rmax = Integer.MIN_VALUE;
        s = 0;
        for (int i = center + 1; i <= right; i++){
            s += vals[i];
            if (s > rmax)
                rmax = s;
        }

        return Math.max(lmax + rmax, Math.max(leftSum, rightSum));
    }


}
