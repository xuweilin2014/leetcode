package xu.two_pointer;


import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 判断子数组中任意两个元素之间的绝对差必须小于或者等于 limit 的关键就是判断子数组中最小值和最大值的差是否小于 limit
 * 使用两个优先队列，一个正序，一个逆序，队列头元素分别保存最小值和最大值
 */
public class Problem1438 {

    public int longestSubarray(int[] nums, int limit) {
        if (nums == null || nums.length < 2)
            return 1;

        int low = 0;
        int high = 1;
        int winLen = 0;
        PriorityQueue<Integer> ascend = new PriorityQueue<>();
        PriorityQueue<Integer> descend = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                return t2 - t1;
            }
        });
        ascend.add(nums[0]);
        descend.add(nums[0]);

        for (high = 1; high < nums.length; high++) {
            ascend.add(nums[high]);
            descend.add(nums[high]);

            int max = descend.peek();
            int min = ascend.peek();

            if (max - min > limit){
                ascend.remove(nums[low]);
                descend.remove(nums[low]);
                low++;
            }else {
                winLen = Math.max(winLen, high - low + 1);
            }
        }

        return winLen;
    }

    public static void main(String[] args) {
        System.out.println(new Problem1438().longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5));
        System.out.println(new Problem1438().longestSubarray(new int[]{4,2,2,2,4,4,2,2}, 0));
        System.out.println(new Problem1438().longestSubarray(new int[]{8,2,4,7}, 4));
        System.out.println(new Problem1438().longestSubarray(new int[]{1,5,6,7,8,10,6,5,6}, 4));
    }

}
