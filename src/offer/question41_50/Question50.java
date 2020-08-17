package offer.question41_50;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question50 {

    private Map<Character, Integer> map = new HashMap<>();

    private List<Character> duplicate = new ArrayList<>();

    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0)
            return ' ';

        if (s.length() == 1)
            return s.charAt(0);

        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (map.containsKey(chs[i])){
                duplicate.add(chs[i]);
            }else{
                map.put(chs[i], i);
            }
        }

        int min = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (!duplicate.contains(entry.getKey())){
                if (min > entry.getValue())
                    min = entry.getValue();
            }
        }

        if (min == Integer.MAX_VALUE)
            return ' ';

        return chs[min];
    }

    public static void main(String[] args) {
        System.out.println(new Question50().firstUniqChar("abaccdefbf"));
    }

}
