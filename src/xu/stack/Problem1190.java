package xu.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem1190 {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == ')'){
                List<Character> tmp = new ArrayList<>();
                while (!stack.isEmpty() && stack.peek() != '('){
                    tmp.add(stack.pop());
                }
                if (!stack.isEmpty())
                    stack.pop();

                for (Character c : tmp) {
                    stack.push(c);
                }
            }else{
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character character : stack) {
            sb.append(character);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Problem1190().reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }
}
