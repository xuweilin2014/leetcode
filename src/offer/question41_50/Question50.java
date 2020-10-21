package offer.question41_50;

import java.util.*;
import java.util.function.BiFunction;

// 哈希表 + 2次遍历
public class Question50 {

    private Map<Character, Integer> map = new LinkedHashMap<>();

    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0)
            return ' ';

        if (s.length() == 1)
            return s.charAt(0);

        char[] chs = s.toCharArray();
        int[] counter = new int[256];
        for (int i = 0; i < chs.length; i++) {
            counter[chs[i]]++;
        }

        for (char ch : chs) {
            if (counter[ch] == 1)
                return ch;
        }

        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(new Question50().firstUniqChar("abaccdefbf"));
    }

}
