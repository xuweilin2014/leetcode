package xu.greedy.problems;

import java.util.Stack;

// 单调栈
public class Problem402 {

    public String removeKdigits(String num, int k) {
        if (num.length() <= k)
            return "0";

        Stack<Character> stack = new Stack<>();
        int counter = k;
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            while (!stack.isEmpty() && counter > 0 && stack.peek() > ch){
                stack.pop();
                counter--;
            }

            stack.push(ch);
        }

        StringBuilder sb = new StringBuilder();
        boolean begin = true;
        for (int i = 0; i < num.length() - k; i++) {
            while (begin && i < num.length() && i < stack.size() && '0' == stack.get(i))
                i++;
            begin = false;
            if (i < stack.size())
                sb.append(stack.get(i));
        }

        if (sb.length() == 0)
            return "0";

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Problem402().removeKdigits("211943", 2));
        System.out.println(new Problem402().removeKdigits("10", 2));
        System.out.println(new Problem402().removeKdigits("10200", 1));
        System.out.println(new Problem402().removeKdigits("1432219", 3));
        System.out.println(new Problem402().removeKdigits("10", 1));
    }

}
