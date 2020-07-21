package xu.dp;

public class Problem121 {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;

        int low = prices[0];
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < low){
                low = prices[i];
            }

            if (prices[i] - low > profit)
                profit = prices[i] - low;
        }

        return profit;
    }

}
