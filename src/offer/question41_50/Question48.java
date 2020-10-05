package offer.question41_50;

import java.util.*;

public class Question48 {

    public int lengthOfLongestSubstring(String s) {
        char[] chs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int low = 0;
        int maxLength = 0;

        for (int i = 0; i < chs.length; i++) {
            if (map.containsKey(chs[i]))
                low = Math.max(map.get(chs[i]) + 1, low);
            map.put(chs[i], i);
            maxLength = Math.max(i - low + 1, maxLength);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new Question48().lengthOfLongestSubstring("abba"));
        System.out.println(new Question48().lengthOfLongestSubstring("dvdf"));
        System.out.println(new Question48().lengthOfLongestSubstring("pwwkew"));
    }

}
