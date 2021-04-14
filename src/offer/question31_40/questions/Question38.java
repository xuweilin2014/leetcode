package offer.question31_40.questions;

import java.util.*;

public class Question38 {

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


    public static void main(String[] args) {
        System.out.println(new Question38().Permutation("aab"));
        System.out.println(new Question38().Permutation("abc"));
    }

}
