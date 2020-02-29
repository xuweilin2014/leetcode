package xu.stack;

import java.util.Stack;

/**
 * 维持一个单调递减（从栈底到栈顶递减）的单调栈，从数组 T 的后面往前面遍历
 */

public class Problem739 {

    static class Pair{
        int val;
        int index;

        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Pair> stack = new Stack<>();
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek().val <= T[i])
                stack.pop();
            if (stack.isEmpty())
                ans[i] = 0;
            else
                ans[i] = stack.peek().index - i;
            stack.push(new Pair(T[i], i));
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] ints = new Problem739().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }
}
