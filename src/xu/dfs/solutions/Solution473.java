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
            // If we have exhausted all our matchsticks, check if all sides of the square are of equal length
            return sum[0] == sum[1] && sum[1] == sum[2] && sum[2] == sum[3];
        }

        // Try adding it to each of the 4 sides (if possible)
        // 尝试把火柴放入到四个桶中，每一个桶的容量为 edge
        for (int i = 0; i < sum.length; i++) {
            // 只有桶的容量还能够放的下元素的时候，才能放入
            if (sum[i] + nums[index] <= edge){
                // 这里有一个非常重要的剪枝操作，即前一个桶的剩余容量和当前桶的剩余容量相同时，可以跳过。这是因为对于某一根火柴来说，
                // 两个桶如果当前大小一样，再放入时是没有区别的，而前面那个桶放入失败，则如果重新放入也肯定失败，故可以直接跳过，实测效率可以提高几十倍
                if (i > 0 && sum[i] == sum[i - 1])
                    continue;

                // 尝试放入火柴
                sum[i] += nums[index];
                boolean ans = func(nums, edge, index +1);
                if (ans)
                    return true;

                // 放入火柴失败，取出火柴，尝试放入到下一个桶中
                sum[i] -= nums[index];
            }
        }

        // 当某一根火柴四个桶都不能放入时，则表明这个火柴序列不能构成正方形
        return false;
    }

}
