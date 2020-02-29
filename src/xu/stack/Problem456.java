package xu.stack;

import java.util.Stack;

/**
 * 本题的基本思想是单调栈：i < j < k  ai < ak < aj
 *
 * 我们首先考虑 a[i] < a[j] 的部分。当我们固定了 j 时，我可以在 j 的左侧找出一个最小的数作为 a[i]，
 * 这是因为最终我们需要满足 a[i] < a[k] < a[j]，那么 a[i] 一定越小越好。因此我们可以对数组 a 维护前缀最小值，
 * 即 min[j] = min(a[1 .. j])，这样对于一个固定的 j，min[j] 即为最优的 a[i]。
 *
 * 随后我们再考虑 a[k]，其中 a[k] 需要满足 a[i] < a[k] < a[j]，即 min[j] < a[k] < a[j]。我们可以从数组 a 的末尾开始，
 * 从后向前寻找 a[k]。我们可以用栈来存储所有的 a[k]。在栈中，所有候选的 a[k] 保持降序，即栈顶的元素最小，栈底的元素最大。
 *
 * 我们在从右向左遍历数组 a 时，假设我们当前位于 a[j]，首先我们判断是否有 nums[j] > min[j]，如果不成立，那么我们要跳过这个 a[j]，
 * 如果成立的话，我们将栈顶的元素依次出栈，直到栈顶元素 stack[top] 满足 stack[top] > min[j]。在这之后，我们可以确定栈中的所有元素都大于 min[j]
 * （即 num[i]），因此如果此时栈顶的元素 stack[top] < nums[j]，则可以满足 132 模式，那么我们就找到了一组合法的满足 132 模式的 i, j, k，
 * 如果 stack[top] > nums[j]。这就使得当前值 nums[j] 可以作为这个栈的最小值进而可以push到当前栈的栈顶，进而解决问题。
 */

public class Problem456 {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3)
            return false;
        Stack < Integer > stack = new Stack < > ();
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            min[i] = Math.min(min[i - 1], nums[i]);
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] > min[j]) {
                while (!stack.isEmpty() && stack.peek() <= min[j])
                    stack.pop();
                if (!stack.isEmpty() && stack.peek() < nums[j])
                    return true;
                stack.push(nums[j]);
            }
        }
        return false;
    }

    public boolean solution1(int[] nums){
        for (int i = 0, min = Integer.MAX_VALUE; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            if (min == nums[i])
                continue;

            for (int j = nums.length - 1; j > i ; j--) {
                if (nums[j] > min && nums[j] < nums[i])
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Problem456()
                .find132pattern(new int[]{-1,3,2,0}));
    }
}
