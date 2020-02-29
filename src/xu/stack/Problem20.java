package xu.stack;

import java.time.OffsetDateTime;
import java.util.Stack;

public class Problem20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else{
                if (c == ')'){
                    if (!stack.isEmpty() && stack.peek() == '(')
                        stack.pop();
                    else
                        stack.push(c);
                }else if (c == '}'){
                    if (!stack.isEmpty() && stack.peek() == '{')
                        stack.pop();
                    else
                        stack.push(c);
                }else if (c == ']'){
                    if (!stack.isEmpty() && stack.peek() == '[')
                        stack.pop();
                    else
                        stack.push(c);
                }
            }
        }

        if (!stack.isEmpty())
            return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Problem20().isValid("[[[()"));
    }
}
