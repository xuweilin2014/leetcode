package xu.backtracking.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem784 {
    public List<String> letterCasePermutation(String S) {
        if ("".equals(S)){
            return new LinkedList<>();
        }

        List<String> list = new ArrayList<>();
        func(S.toLowerCase().toCharArray(), list, 0, S.length());
        return list;
    }

    private void func(char[] chars, List<String> list, int index, int length) {
        if (index == length){
            list.add(new String(chars));
            return;
        }

        if (chars[index] >= '0' && chars[index] <= '9'){
            func(chars, list, index + 1, length);
            return;
        }

        func(chars.clone(), list, index + 1, length);

        chars[index] = Character.toUpperCase(chars[index]);
        func(chars.clone(), list, index + 1, length);
    }


    public static void main(String[] args) {
        List<String> strings = new Problem784().letterCasePermutation("RmR");
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
