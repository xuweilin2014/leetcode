package xu.backtracking.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem17 {

    private char[][] numbers = new char[][]{
        {},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},
            {'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}
    };
    private List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if ("".equals(digits)) {
            return new ArrayList<>();
        }
        dfs(digits.toCharArray(), 0, digits.length(), "");
        return res;
    }

    private void dfs(char[] chars, int index, int length, String path) {
        if (index == length){
            res.add(path);
            return;
        }

        int ix = chars[index] - '1';
        for (int i = 0; i < numbers[ix].length; i++) {
            dfs(chars, index + 1, length, path + numbers[ix][i]);
        }
    }

    public static void main(String[] args) {
        List<String> strings = new Problem17().letterCombinations("946");
        System.out.println(strings.size());
        System.out.println(strings);
    }
}
