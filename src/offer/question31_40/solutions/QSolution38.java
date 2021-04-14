package offer.question31_40.solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QSolution38 {

    /**
     * 字符串的排列
     *
     * 这道题目要求出一个字符串的所有排列，并且不能有重复的排列，比如 "aab"，它就不能生成两个 aab 排列。
     * 因此当字符串存在重复字符时，排列方案中也存在重复的排列方案。为了排除重复方案，需要在固定某位字符时，
     * 保证 "每种字符只在此位固定一次"，直接跳过。
     *
     * 在下面的 func 函数中，【每一层递归都相当于是排列中的某一位】，所以在这一位，相同的字符不允许出现多次。
     * 并且，一共有两个限制条件，一个是 visited，限制字符串中的每一个字符只能使用一次；第二个条件是 set，就是
     * 排列中的某一位字符只能出现一个字符，不能出现多次。
     */

    private ArrayList<String> ans = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0)
            return new ArrayList<>();

        int[] visited = new int[str.length()];
        func(str.toCharArray(), "", visited);
        return ans;
    }

    private void func(char[] chs, String path, int[] visited) {
        if (path.length() == chs.length) {
            ans.add(path);
            return;
        }

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < chs.length; i++) {
            if (set.contains(chs[i]) || visited[i] == 1)
                continue;
            set.add(chs[i]);
            visited[i] = 1;
            func(chs, path + chs[i], visited);
            visited[i] = 0;
        }
    }

}
