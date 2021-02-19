package xu.backtracking.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem17 {

    private static Map<Integer, Character[]> map = new HashMap<>();

    private List<String> ans = new ArrayList<>();

    static {
        map.put(2, new Character[]{'a', 'b', 'c'});
        map.put(3, new Character[]{'d', 'e', 'f'});
        map.put(4, new Character[]{'g', 'h', 'i'});
        map.put(5, new Character[]{'j', 'k', 'l'});
        map.put(6, new Character[]{'m', 'n', 'o'});
        map.put(7, new Character[]{'p', 'q', 'r', 's'});
        map.put(8, new Character[]{'t', 'u', 'v'});
        map.put(9, new Character[]{'w', 'x', 'y', 'z'});
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return ans;

        func(digits, 0, new StringBuilder());
        return ans;
    }

    private void func(String digits, int index, StringBuilder path) {
        if (index == digits.length()){
            ans.add(path.toString());
            return;
        }

        Character[] list = map.get(digits.charAt(index) - '0');
        for (Character ch : list) {
            path.append(ch);
            func(digits, index + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> strings = new Problem17().letterCombinations("23");
        System.out.println(strings.size());
        System.out.println(strings);
    }
}
