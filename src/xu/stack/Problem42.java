package xu.stack;

import java.util.Stack;

/**
 * 我们对低洼的地方感兴趣，就可以使用一个单调递减栈，将递减的边界存进去，一旦发现当前的数字大于栈顶元素了，
 * 那么就有可能会有能装水的地方产生。此时我们当前的数字是右边界，我们从栈中至少需要有两个数字，才能形成一个坑槽，
 * 先取出的那个最小的数字，就是坑槽的最低点，再次取出的数字就是左边界，我们比较左右边界，取其中较小的值为装水的边界，
 * 然后此高度减去水槽最低点的高度，乘以左右边界间的距离就是装水量了。
 */

public class Problem42 {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int area = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                int h = stack.pop();
                if (!stack.isEmpty() && height[h] != height[i]){
                    area += (i - stack.peek() - 1) *
                            (Math.min(height[i], height[stack.peek()]) - height[h]);
                }
            }
            stack.push(i);
        }

        return area;
    }

    public static void main(String[] args) {
        System.out.println(new Problem42().trap(new int[]{1, 0, 3, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
