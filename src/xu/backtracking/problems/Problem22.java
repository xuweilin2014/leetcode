package xu.backtracking.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 0 代表 （
 * 1 代表 ）
 */

public class Problem22 {

    private List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0)
            return ans;

        func(n, n, new StringBuilder());
        return ans;
    }

    private void func(int left, int right, StringBuilder path) {
        if (left > right || left < 0)
            return;
        if (left == 0 && right == 0){
            ans.add(path.toString());
            return;
        }

        path.append('(');
        func(left - 1, right, path);
        path.deleteCharAt(path.length() - 1);

        path.append(')');
        func(left, right - 1, path);
        path.deleteCharAt(path.length() - 1);
    }

    public static void main(String[] args) {
        List<String> list = new Problem22().generateParenthesis(3);
        for (String s : list) {
            System.out.println(s);
        }

        list = new Problem22().generateParenthesis(1);
        for (String s : list) {
            System.out.println(s);
        }
    }

}
