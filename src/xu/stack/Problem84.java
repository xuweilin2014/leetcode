package xu.stack;

import java.util.Stack;

public class Problem84 {

    static class Pair{
        int val;
        int index;

        public Pair(int val, int span) {
            this.val = val;
            this.index = span;
        }
    }

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0)
            return 0;

        Stack<Pair> stack = new Stack<>();
        int[] ls = new int[heights.length];
        int[] rs = new int[heights.length];

        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek().val >= heights[i])
                stack.pop();
            if (stack.isEmpty())
                rs[i] = heights.length - 1 - i;
            else
                rs[i] = stack.peek().index - i - 1;
            stack.push(new Pair(heights[i], i));
        }
        stack.clear();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && stack.peek().val >= heights[i])
                stack.pop();

            if (stack.isEmpty())
                ls[i] = i;
            else
                ls[i] = i - stack.peek().index - 1;
            stack.push(new Pair(heights[i], i));
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < ls.length; i++) {
            int s = heights[i] * (ls[i] + rs[i] + 1);
            if (s > max)
                max = s;
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Problem84()
                .largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
