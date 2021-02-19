package xu.backtracking.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem131 {

    private List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0)
            return ans;

        func(s, 0, new ArrayList<>());
        return ans;
    }

    private void func(String s, int low, List<String> path) {
        if (low == s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = low; i < s.length(); i++) {
            if (isPalindrome(s, low, i)){
                path.add(s.substring(low, i + 1));
                func(s, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str, int low, int high) {
        while (low < high){
            if (str.charAt(low) == str.charAt(high)){
                low++;
                high--;
            }else {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        List<List<String>> lists = new Problem131().partition("abba");
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }
}
