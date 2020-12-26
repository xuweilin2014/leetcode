package xu.two_pointer.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 本题的关键在于如何判断字符串 s2 的一个子串是 s1 的某个排列的一种
 */
public class Problem567 {

    private Map<Character, Integer> alpha;

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        this.alpha = new HashMap<>();
        int span = s1.length();
        for (int i = 0; i < 26; i++) {
            alpha.put((char) ('a' + i), (new Random().nextInt(10000) + i));
        }

        long target = 0;
        long window = 0;
        for (int i = 0; i < s1.length(); i++) {
            target += alpha.get(s1.charAt(i));
            window += alpha.get(s2.charAt(i));
        }

        for (int i = 0; i < s2.length() - span + 1; i++) {
            if (i > 0)
                window = window - alpha.get(s2.charAt(i - 1)) + alpha.get(s2.charAt(i + span - 1));
            if (window == target)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Problem567().checkInclusion("ab", "eidbaooo"));
        System.out.println(new Problem567().checkInclusion("ab", "eidboaoo"));
    }

}
