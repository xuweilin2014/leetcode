package xu.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 分治算法
 */
public class Problem395 {

    private int k;

    public int longestSubstring(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        this.k = k;

        return func(s);
    }

    private int func(String s) {
        if (s.length() == 1)
            return k == 1 ? 1 : 0;

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.merge(ch, 1, Integer::sum);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() < k){
                int index = s.indexOf(entry.getKey());

                int i = index;
                while (i < s.length() && s.charAt(i) == s.charAt(index))
                    i++;

                int left = func(s.substring(0, index));
                int right = i >= s.length() ? 0 : func(s.substring(i));
                return Math.max(left, right);
            }
        }

        return s.length();
    }


    public static void main(String[] args) {
        System.out.println(new Problem395().longestSubstring("aaabb", 3));
        System.out.println(new Problem395().longestSubstring("bbaaacbd", 3));
        System.out.println(new Problem395().longestSubstring("bbaaacbd", 2));
        System.out.println(new Problem395().longestSubstring("weitong", 2));
    }

}
