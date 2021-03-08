package xu.dfs.solutions;

import java.util.Arrays;

public class Solution473 {

    /*
     * 火柴拼正方形
     *
     * 这道题目可以使用深度优先搜索的方式来解决，可以换一种思考方式来解决。比如，对于序列 [1,2,4,6,7,10,10]，要拼成一个正方形，也就是
     * 拼成一个边长为 10 的正方形。这里我们可以看成是有 4 个容量为 10 的桶，在遍历序列中的每一个元素时，我们可以决定将这个元素加到
     * 哪一个桶中。
     *
     * 最后，当序列遍历完成时，判断这 4 个桶中元素之和是否全部相等，如果相等的话，就说明可以拼成正方形，否则就不可以。
     *
     * 我们依次对每一根火柴进行搜索，当搜索到第 i 根火柴时，我们可以把它放到四组中的任意一种。对于每一种放置方法，我们继续对第 i + 1
     * 根火柴进行递归搜索。当我们搜索完全部的 N 根火柴后，再判断每一组火柴的长度之和是否都相同
     */

    private int[] sum = new int[4];

    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4)
            return false;

        Arrays.sort(nums);
        int sum = 0;
        int edge;

        for (int num : nums) {
            sum += num;
        }
        if (sum % 4 == 0)
            edge = sum / 4;
        else
            return false;

        return func(nums, edge, 0);
    }

    private boolean func(int[] nums, int edge, int index) {
        if (nums.length == index){
            return sum[0] == sum[1] && sum[1] == sum[2] && sum[2] == sum[3];
        }

        for (int i = 0; i < sum.length; i++) {
            if (sum[i] + nums[index] <= edge){
                if (i > 0 && sum[i] == sum[i - 1])
                    continue;

                sum[i] += nums[index];
                boolean ans = func(nums, edge, index +1);
                if (ans)
                    return true;
                sum[i] -= nums[index];
            }
        }

        return false;
    }

}
