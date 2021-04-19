package offer.question41_50.solutions;

public class QSolution49 {

    /*
     * 丑数
     *
     * 一个十分巧妙的动态规划问题
     * 1.我们将前面求得的丑数记录下来，后面的丑数就是前面的丑数 *2，*3，*5
     * 2.但是问题来了，我怎么确定已知前面 k-1 个丑数，我怎么确定第 k 个丑数呢
     * 3.采取用三个指针的方法，p2,p3,p5
     * 4.p2 指向的数字下一次永远 *2，p3 指向的数字下一次永远 *3，p5 指向的数字永远 *5
     * 5.我们从 2*p2 3*p3 5*p5选 取最小的一个数字，作为第 k 个丑数
     * 6.如果第 K 个丑数 == 2*p2，也就是说前面 0-p2 个丑数 *2 不可能产生比第K个丑数更大的丑数了，所以 p2++
     * 7.p3,p5 同理
     * 8.返回第 n 个丑数
     */

    public int GetUglyNumber_Solution(int index) {
        if (index <= 1)
            return index;

        int[] dp = new int[index + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;

        for (int i = 2; i <= index; i++) {
            dp[i] = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
            if (dp[i] == dp[p2] * 2)
                p2++;
            if (dp[i] == dp[p3] * 3)
                p3++;
            if (dp[i] == dp[p5] * 5)
                p5++;
        }

        return dp[dp.length - 1];
    }

}
