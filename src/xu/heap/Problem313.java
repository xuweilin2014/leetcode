package xu.heap;

/**
 * 假设primes数组为{2,3,5}，让我们从数组中只包含一个丑数数字 1 开始，使用三个指针 i2，i3，i5，
 * 标记所指向丑数要乘以的因子。
 *
 * 算法很简单：在 2 * nums[i2]、3 * nums[i3]、5 * nums[i5]， 选出最小的丑数并添加到数组中。
 * 并将该丑数对应的因子指针往前走一步。重复该步骤直到计算完 n 个丑数。
 *
 */

public class Problem313 {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] vals = new int[n];
        int[] index = new int[primes.length];
        vals[0] = 1;
        int counter = 1;
        while (counter < n){
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < index.length; i++) {
                if (min > primes[i] * vals[index[i]])
                    min = primes[i] * vals[index[i]];
            }
            vals[counter++] = min;
            for (int i = 0; i < index.length; i++) {
                if (vals[index[i]] * primes[i] == min)
                    index[i]++;
            }
        }
        return vals[n-1];
    }

    public static void main(String[] args) {
        System.out.println(new Problem313()
                .nthSuperUglyNumber(1600, new int[]{2,3,5}));
    }
}
