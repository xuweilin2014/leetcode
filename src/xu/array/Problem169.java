package xu.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 求一个数组中的多余元素，使用摩尔投票法
 *
 * 候选人(cand_num)初始化为nums[0]，票数count初始化为1。
 * 当遇到与cand_num相同的数，则票数count = count + 1，否则票数count = count - 1。
 * 当票数count为0时，更换候选人，并将票数count重置为1。
 * 遍历完数组后，cand_num即为最终答案。
 *
 * 为何这行得通呢？
 * 投票法是遇到相同的则票数 + 1，遇到不同的则票数 - 1。
 * 且"多数元素"的个数> ⌊ n/2 ⌋，其余元素的个数总和<= ⌊ n/2 ⌋。
 * 因此"多数元素"的个数 - 其余元素的个数总和 的结果 肯定 >= 1。
 * 这就相当于每个“多数元素”和其他元素 两两相互抵消，抵消到最后肯定还剩余至少1个"多数元素"。
 *
 */
public class Problem169 {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 3,3,3,3,3,3}));
    }

    public static int majorityElement(int[] nums) {
        int candNum = nums[0];
        int counter = 1;
        for (int i = 1; i < nums.length; i++) {
            if (candNum == nums[i]){
                counter++;
            }else{
                counter--;
            }

            if (counter == 0){
                candNum = nums[i];
                counter = 1;
            }
        }

        return candNum;
    }
}
