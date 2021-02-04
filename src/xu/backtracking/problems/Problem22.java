package xu.backtracking.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 0 代表 （
 * 1 代表 ）
 */

public class Problem22 {

    private Stack<Integer> stack = new Stack<>();
    private List<List<Integer>> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        return solution2(n);
    }

    private List<String> solution2(int n) {
        List<String> list = new ArrayList<>();
        helper(list, "", 0, 0, n);
        return list;
    }

    private void helper(List<String> list, String str, int open, int close, int max) {
        if (str.length() == 2 * max) {
            list.add(str);
            return;
        }

        if (open < max)
            helper(list, str + "(", open + 1, close, max);
        if (close < open)
            helper(list, str + ")", open, close + 1, max);

    }

    private List<String> solution1(int n){
        dfs(n* 2, 0, new ArrayList<>());
        List<String> list = new ArrayList<>();
        for (List<Integer> re : res) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < re.size(); i++) {
                if (re.get(i) == 0) sb.append("(");
                else sb.append(")");
            }
            list.add(sb.toString());
        }
        return list;
    }

    private void dfs(int length, int index, List<Integer> vals) {
        if (index == length){
            if (stack.isEmpty())
                res.add(new ArrayList<>(vals));
            return;
        }

        for (int i = 0; i < 2; i++) {
            boolean isPush = false;
            boolean isPop = false;
            int tmp = 0;
            if ( !stack.isEmpty() && stack.peek() == 0 && i == 1) {
                isPop = true;
                tmp = stack.pop();
            }
            else {
                isPush = true;
                stack.push(i);
            }
            vals.add(i);
            dfs(length, index + 1, vals);
            vals.remove(vals.size() - 1);

            if (isPush)
                stack.pop();
            if (isPop)
                stack.push(tmp);
        }
    }

    public static void main(String[] args) {
        List<String> list = new Problem22().generateParenthesis(3);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
