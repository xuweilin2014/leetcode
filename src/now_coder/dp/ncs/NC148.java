package now_coder.dp.ncs;

import java.util.Arrays;

public class NC148 {

    public int Jump(int n, int[] nums) {
        if (nums == null || nums.length <= 1)
            return 0;

        int max_dist = 0;
        int step = 0;
        int end = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            max_dist = Math.max(max_dist, i + nums[i]);

            if (end == i){
                end = max_dist;
                step++;
            }
        }

        return step;
    }

    public static void main(String[] args) {
        System.out.println(new NC148().Jump(5, new int[]{2, 3, 1, 1, 4}));
        System.out.println(new NC148().Jump(8, new int[]{3, 7, 6, 1, 2, 1, 1, 5}));
    }

}
