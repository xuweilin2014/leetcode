package xu.greedy.problems;

public class Problem122 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;

        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]){
                profit += (prices[i] - prices[i - 1]);
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        System.out.println(new Problem122().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new Problem122().maxProfit(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(new Problem122().maxProfit(new int[]{7, 6, 5, 4, 3, 2, 1}));
        System.out.println(new Problem122().maxProfit(new int[]{7, 1, 1, 3, 3, 10, 9}));
        System.out.println(new Problem122().maxProfit(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(new Problem122().maxProfit(new int[]{7, 6, 5, 5, 10, 13, 1}));
    }

}
