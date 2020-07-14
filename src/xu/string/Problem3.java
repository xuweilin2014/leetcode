package xu.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符串的最长子串，使用哈希+滑动窗口（其实也就是双指针）解决
 */
public class Problem3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("accauuukikwwkl"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;

        char[] chs = s.toCharArray();
        Map<Character, Integer> chToIndex = new HashMap<>();
        int l = 0, r = 0;
        int maxLen = 0;

        while (r < chs.length){
            if (chToIndex.containsKey(chs[r])){
                int dupIndex = chToIndex.get(chs[r]);
                if (r - l > maxLen)
                    maxLen = r - l;

                if (dupIndex + 1 > l)
                    l = dupIndex + 1;
            }

            chToIndex.put(chs[r], r);
            r++;
        }

        if (r - l > maxLen)
            maxLen = r - l;

        return maxLen;
    }

}
