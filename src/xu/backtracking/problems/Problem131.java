package xu.backtracking.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem131 {

    private List<List<String>> list = new ArrayList<>();
    private int length;

    public List<List<String>> partition(String s) {
        this.length = s.length();
        StringBuilder sb = new StringBuilder(s);
        dfs(sb, 0, new ArrayList<>());
        return list;
    }

    private void dfs(StringBuilder rawStr, int index, List<String> path) {
        if (index == length){
            list.add(new ArrayList<>(path));
            return;
        }

        StringBuilder sb;
        for (int i = index; i < rawStr.length(); i++) {
            sb = new StringBuilder();
            String substring = rawStr.substring(index, i + 1);
            if (!isPalindrome(substring.toCharArray()))
                continue;
            sb.append(substring);
            path.add(sb.toString());
            dfs(rawStr, i + 1, path);
            path.remove(path.size() - 1);
        }
    }

    public boolean isPalindrome(char[] chars){
        int slow = 0;
        int high = chars.length - 1;
        while (slow < high){
            if (chars[slow] != chars[high])
                return false;
            slow++;
            high--;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> lists = new Problem131().partition("eeeee");
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }
}
