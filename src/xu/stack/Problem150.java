package xu.stack;

import java.util.Stack;

public class Problem150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> vals = new Stack<>();

        for (String token : tokens) {
            if (!"*".equals(token) && !"-".equals(token)
                    && !"+".equals(token) && !"/".equals(token))
                vals.push(Integer.parseInt(token));
            else{
                int val1 = vals.pop();
                int val2 = vals.pop();
                int res = 0;
                if ("*".equals(token))
                    res = val1 * val2;
                else if ("/".equals(token))
                    res = val2 / val1;
                else if ("+".equals(token))
                    res = val1 + val2;
                else
                    res = val2 - val1;
                vals.push(res);
            }
        }

        return vals.pop();
    }

    public static void main(String[] args) {
        System.out.println(new Problem150().evalRPN(new String[]{"10", "6", "-"}));
    }
}
