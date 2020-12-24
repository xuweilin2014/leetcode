package offer.Question61_68;

import java.util.Stack;

public class Question63 {
    // 单调栈解法
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;

        int maxProfit = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(prices[0]);
        for (int i = 1; i < prices.length; i++) {
            while (!stack.isEmpty() && stack.peek() > prices[i]){
                stack.pop();
            }

            if (!stack.isEmpty()){
                maxProfit = Math.max(maxProfit, prices[i] - stack.get(0));
            }
            stack.push(prices[i]);
        }

        return maxProfit;
    }

    // 在遍历数组的过程中，维护一个最小值，最小值初始值为 prices[0]
    // 1.如果 prices[i] 大于 min。则去更新一下利润 res
    // 2.否则说明当前的 prices[i] 比 min 还小，则更新 min
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;

        int maxProfit = 0;
        int min = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < min) {
                min = price;
            }

            maxProfit = Math.max(maxProfit, price - min);
        }


        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(new Question63().maxProfit(new int[]{7, 8, 5, 3, 2, 1}));
        System.out.println(new Question63().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new Question63().maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

}
