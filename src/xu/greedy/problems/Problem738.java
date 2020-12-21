package xu.greedy.problems;

import java.util.Stack;

// 738、402、316 都是使用单调栈的题目，强烈推荐看 https://leetcode-cn.com/problems/remove-k-digits/solution/yi-zhao-chi-bian-li-kou-si-dao-ti-ma-ma-zai-ye-b-5/
// 的题解，基本的思想就是遍历数字 N，然后在每一位都进行丢弃和保留的选择即可
public class Problem738 {

    public int monotoneIncreasingDigits(int N) {
        if (N >= 0 && N <= 10)
            return N - 1;

        Stack<Integer> stack = new Stack<>();
        boolean changed = false;
        String val = String.valueOf(N);

        for (int i = 0; i < val.length(); i++) {
            if (changed){
                stack.push(9);
                continue;
            }

            int num = val.charAt(i) - '0';
            while (!stack.isEmpty() && stack.peek() > num){
                num = stack.pop() - 1;
                changed = true;
                i--;
            }

            stack.push(num);
        }

        int ans = 0;
        for (Integer integer : stack) {
            ans = ans * 10 + integer;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Problem738().monotoneIncreasingDigits(1374));
        System.out.println(new Problem738().monotoneIncreasingDigits(13478042));
        System.out.println(new Problem738().monotoneIncreasingDigits(1234));
        System.out.println(new Problem738().monotoneIncreasingDigits(109));
    }

}
