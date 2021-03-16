package offer.question31_40.questions;

import java.util.*;

public class Question38 {

    private List<String> res = new LinkedList<>();

    private char[] c;

    public String[] permutation(String s) {
       c = s.toCharArray();
       dfs(0);
       return res.toArray(new String[0]);
    }

    private void dfs(int x) {
        if (x == c.length){
            res.add(String.valueOf(c));
            return;
        }

        Set<Character> dup = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if (dup.contains(c[i]))
                continue;
            dup.add(c[i]);
            swap(x, i);
            dfs(x + 1);
            swap(i, x);
        }
    }

    private void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }



    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Question38().permutation("abc")));
    }

}
