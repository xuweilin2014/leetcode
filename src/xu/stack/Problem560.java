package xu.stack;

import java.util.HashMap;
import java.util.Map;

/**
 * 借助哈希表保存累加和sum及出现的次数。若累加和sum-k在哈希表中存在，则说明存在连续序列使得和为k。
 * 则之前的累加和中，sum-k出现的次数即为有多少种子序列使得累加和为sum-k。
 */

public class Problem560 {
    public int subarraySum(int[] nums, int k) {
        int[] presum = new int[nums.length+1];
        int sum = 0, counter = 0;
        presum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            presum[i+1] = sum;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 1; i < presum.length; i++) {
            if (map.containsKey(presum[i] - k)) {
                counter += map.get(presum[i] - k);
            }
            if (map.containsKey(presum[i]))
                map.put(presum[i], map.get(presum[i]) + 1);
            else
                map.put(presum[i], 1);
        }

        return counter;
    }

    public static void main(String[] args) {
        System.out.println(new Problem560()
                .subarraySum(new int[]{0,0,0,0,0,0,0,0,0,0}, 0));
    }
}
