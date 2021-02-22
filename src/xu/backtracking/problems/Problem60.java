package xu.backtracking.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 求第 k 个排列
 *
 * 算法的主要思想就是对 1...n 位数分别进行计算，例如，假如给定题目为（5,46）。固定第一位数，后面4位的全排列数为24，
 * math.ceil(46/24)=2,即处于第 1 位数的第二个循环中，即第一位数为 2，然后按照同样的方法不断进行迭代，求出整个 n
 * 位数
 */
public class Problem60 {

    public String getPermutation(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; ++i) {
            factorial[i] = factorial[i - 1] * i;
        }


        /*
         * k 需要先自减一 原因：
         * 不妨设分子为 k，那么得到的公式可能是这样的：
         * ai =  ⌊k / (n-1)!⌋ + 1
         * 尝试使用以上公式计算 a1:
         * （1）当 k < (n-1)! 时，a1 = ⌊k / (n-1)!⌋ + 1 = 1，正确
         * （2）当 k = (n-1)! 时，a1 = ⌊k / (n-1)!⌋ + 1 = 2，错误
         * 而使用 ai =  ⌊(k-1) / (n-1)!⌋ + 1 却能正确处理这种情况
         * 即：只是简洁了数学公式的使用，如果不自减一的话，需要应对多种情况
        */

        --k;
        StringBuilder ans = new StringBuilder();
        // 0，1...n 排列标志集，标识在一整次寻找中哪个数已进排列中
        int[] valid = new int[n + 1];
        Arrays.fill(valid, 1);

        // 排列中 依次取得的排列的数的个数 1个...n个
        for (int i = 1; i <= n; ++i) {
            // 此公式可算出上面的数对应的从 1...n 中哪个数 order | n - i 为了对应 factorial 下标,获取剩余个数排列种类总数
            int order = k / factorial[n - i] + 1;

            // 依次寻找对应的数 从 1...n
            for (int j = 1; j <= n; ++j) {
                order -= valid[j];

                // 找到一个数，若没有进入过结果排列集，减一，直至 order == 0 则表示找到该排列中的第 i 个数，修改标志集对应位置为已进入结果排序集
                if (order == 0) {
                    ans.append(j);
                    valid[j] = 0;
                    break;
                }
            }

            // 之后 k 对于已取得的数的排列位数取余，得到下一位需要的
            k %= factorial[n - i];
        }

        return ans.toString();
    }


    public static void main(String[] args) {
        System.out.println(new Problem60().getPermutation(4, 2));
        System.out.println(new Problem60().getPermutation(3, 5));
        System.out.println(new Problem60().getPermutation(4, 9));
        System.out.println(new Problem60().getPermutation(4, 1));
    }
}
