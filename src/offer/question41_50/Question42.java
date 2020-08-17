package offer.question41_50;

import java.util.Map;

public class Question42 {

    public static void main(String[] args) {
        System.out.println(FindGreatestSumOfSubArray(new int[]{-2}));
    }

    public static int FindGreatestSumOfSubArray(int[] array) {
        return doFind(array, 0, array.length - 1);
    }

    private static int doFind(int[] array, int left, int right) {
        if (left >= right)
            return array[left];

        int mid = (left + right) / 2;

        int midVal = getMaxValue(array, left, right, mid);
        int leftVal = doFind(array, left, mid - 1);
        int rightVal = doFind(array, mid + 1, right);

        return Math.max(midVal, Math.max(leftVal, rightVal));
    }

    private static int getMaxValue(int[] array, int left, int right, int mid){
        int maxRight = array[mid];
        int sum = array[mid];
        for (int i = mid + 1; i <= right; i++) {
            sum += array[i];
            if (sum > maxRight)
                maxRight = sum;
        }

        sum = array[mid];
        int maxLeft = array[mid];
        for (int i = mid - 1; i >= left; i--) {
            sum += array[i];
            if (sum > maxLeft)
                maxLeft = sum;
        }

        return maxLeft + maxRight - array[mid];
    }

}
