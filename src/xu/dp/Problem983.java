package xu.dp;

import java.util.ArrayList;
import java.util.List;

public class Problem983 {

    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days[days.length - 1] + 1];
        List<Integer> list = new ArrayList<>();
        for (int day : days) {
            list.add(day);
        }

        for (int day = 1; day < dp.length; day++) {
            if (list.contains(day)){
                dp[day] = Math.min(
                  dp[Math.max(0, day - 1)] + costs[0],
                  Math.min(dp[Math.max(0, day - 7)] + costs[1],
                           dp[Math.max(0, day - 30)] + costs[2])
                );
            }else {
                dp[day] = dp[day - 1];
            }
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Problem983().mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 13}));
        System.out.println(new Problem983().mincostTickets(new int[]{1,2,3,4,5,6,7,8,9,10,30,31}, new int[]{2, 7, 15}));
    }

}
