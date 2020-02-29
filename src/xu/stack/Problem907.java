package xu.stack;

import java.util.Stack;

/**
 * 此题的思路和求矩形的最大面积一样，需要界定一个元素左右连续比它大的元素个数。往左
 * 找到第一个小于等于它的元素作为左边界，大于它的元素作为右边界。然后就可以算出以该元素作为最小值的数组个数。
 * 根据元素x的左右边界确定其左右连续比它大的元素个数以（a,b）表示，
 * 则以元素 x 为最小值的数组个数为 a + b + a*b + 1（包括x本身）
 */

public class Problem907 {

    private long MOD = 1_000_000_000 + 7;

    static class Pair{
        int val;
        int index;

        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public int sumSubarrayMins(int[] A) {
        int[] ls = new int[A.length];
        int[] rs = new int[A.length];
        Stack<Pair> left = new Stack<>();
        Stack<Pair> right = new Stack<>();
        for (int i = 0, j = A.length - 1; i < A.length && j >= 0; i++, j--) {
            while (!left.isEmpty() && left.peek().val >= A[i]){
                left.pop();
            }

            while (!right.isEmpty() && right.peek().val > A[j]){
                right.pop();
            }

            if (left.isEmpty())
                ls[i] = i;
            else
                ls[i] = i - left.peek().index - 1;

            if (right.isEmpty())
                rs[j] = A.length - 1 - j;
            else
                rs[j] = right.peek().index - j - 1;
            left.push(new Pair(A[i], i));
            right.push(new Pair(A[j], j));
        }

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += (1 + rs[i] + ls[i] + rs[i] * ls[i]) * A[i];
            sum %= MOD;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Problem907()
                .sumSubarrayMins(new int[]{71,55,82,55}));
    }
}
