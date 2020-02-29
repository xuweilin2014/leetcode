package xu.stack;

import java.util.Stack;

public class Problem473 {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            boolean flag = false;
            while (!stack.isEmpty() && stack.peek().equals(c)) {
                stack.pop();
                flag = true;
            }

            if (!flag)
                stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        for (Character ch : stack) {
            sb.append(ch);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Problem473().removeDuplicates("abbaca"));
    }
}
