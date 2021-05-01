package now_coder.dp.solutions;

public class NCSolution148 {

    /*
     * 从头跳到尾
     *
     * 这道题目的思想就是：每次在上次可以跳到的最远范围内（end）选择一个能跳的最远的位置（也就是能跳到 max_dist 位置的点）
     * 作为下次的起跳点。
     */

    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 0;

        int max_dist = 0; // 目前能够跳到的最远位置
        int step = 0;  // 跳跃的次数
        int end = 0;  // 上一次跳跃可以达到的范围的右边界

        for (int i = 0; i < nums.length - 1; i++) {
            max_dist = Math.max(max_dist, i + nums[i]);

            // 到达上次跳跃能够到达的右边界
            if (end == i){
                // 目前能跳到的最远位置变成了下次起跳位置的右边界
                end = max_dist;
                // 进入下一次跳跃
                step++;
            }
        }

        return step;
    }

}
