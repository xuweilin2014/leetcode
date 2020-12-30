package xu.stack;

import java.util.Stack;


public class Problem1249 {

    public String minRemoveToMakeValid(String s) {
        if (s == null || s.length() == 0)
            return s;

        Stack<Integer> indices = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (ch == '('){
                indices.push(i);
            }else if (ch == ')'){
                if (!indices.isEmpty() && s.charAt(indices.peek()) == '('){
                    indices.pop();
                }else {
                    indices.push(i);
                }
            }
        }

        int counter = 0;
        for (Integer index : indices) {
            sb.deleteCharAt(index - counter);
            counter++;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Problem1249().minRemoveToMakeValid("))(("));
        System.out.println(new Problem1249().minRemoveToMakeValid("())()((("));
        System.out.println(new Problem1249().minRemoveToMakeValid("(a(b(c)d)"));
        System.out.println(new Problem1249().minRemoveToMakeValid("))(("));
        System.out.println(new Problem1249().minRemoveToMakeValid("a)b(c)d"));
        System.out.println(new Problem1249().minRemoveToMakeValid("lee(t(c)o)de)"));
    }

}
