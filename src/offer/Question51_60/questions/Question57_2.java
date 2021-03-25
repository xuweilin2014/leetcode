package offer.Question51_60.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 滑动窗口或者说双指针
 */
public class Question57_2 {

    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int low = 0;
        int high = 0;
        int sum = 0;

        while (high <= target){
            while (high <= target && sum < target){
                high++;
                sum += high;
            }

            while (high <= target && sum > target){
                sum -= low;
                low++;
            }

            if (sum == target){
                low = low == 0 ? low + 1 : low;
                if (high != low){
                    int[] arr = new int[high - low + 1];
                    for (int i = low; i <= high ; i++) {
                        arr[i - low] = i;
                    }
                    res.add(arr);
                }

                high++;
                sum += high;
            }
        }

        int[][] seq = new int[res.size()][];
        for (int i = 0; i < seq.length; i++) {
            seq[i] = res.get(i);
        }

        return seq;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Question57_2().findContinuousSequence(15)));
    }

}
