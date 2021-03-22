package offer.question31_40.questions;

import java.util.*;

public class Question38 {

    public String[] permutation(String s) {
        if (s == null || s.length() == 0)
            return new String[0];

        char[] chs = s.toCharArray();
        int[] times = new int[s.length()];

        StringBuilder path = new StringBuilder();
        List<String> list = new ArrayList<>();
        func(path, chs, times, list);

        return list.toArray(new String[0]);
    }

    private void func(StringBuilder path, char[] chs, int[] times, List<String> list) {
        if (path.length() == chs.length){
            list.add(path.toString());
            return;
        }

        Set<Character> sets = new HashSet<>();
        for (int i = 0; i < chs.length; i++) {
            if (times[i] == 1 || sets.contains(chs[i]))
                continue;

            sets.add(chs[i]);
            times[i] = 1;
            path.append(chs[i]);
            func(path, chs, times, list);
            path.deleteCharAt(path.length() - 1);
            times[i] = 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Question38().permutation("aab")));
        System.out.println(Arrays.toString(new Question38().permutation("abc")));
    }

}
