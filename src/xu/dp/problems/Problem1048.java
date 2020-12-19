package xu.dp.problems;

import java.util.Arrays;
import java.util.Comparator;

public class Problem1048 {

    public int longestStrChain(String[] words) {
        if (words == null || words.length == 0)
            return 0;
        if (words.length == 1)
            return 1;

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });

        int[] dp = new int[words.length];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (words[j].length() + 1 < words[i].length())
                    break;
                if (words[j].length() + 1 == words[i].length()){
                    if (func(words[i], words[j])){
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                        maxLen = Math.max(maxLen, dp[i]);
                    }
                }
            }
        }

        return maxLen;
    }

    private boolean func(String word1, String word2){
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int counter = 0;
        int p1 = 0;
        int p2 = 0;

        while (p1 < w1.length && p2<w2.length){
            if (w1[p1] == w2[p2]){
                p1++;
                p2++;
            }else {
                p1++;
                counter++;
            }
            if (counter > 1)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Problem1048().longestStrChain(new String[]{
                "a","b","ba","bdca","bca","bda", "bdacd", "bbbbbbbb"
        }));
        System.out.println(new Problem1048().longestStrChain(new String[]{
                "a","b","bba","bdca","bca","bda", "bdacd", "bbbbbbbb"
        }));
        System.out.println(new Problem1048().longestStrChain(new String[]{
                "xbc","pcxbcf","xb","cxbc","pcxbc"
        }));
        System.out.println(new Problem1048().longestStrChain(new String[]{
                "a","b","ab","bac"
        }));
        System.out.println(new Problem1048().longestStrChain(new String[]{
                "a","ca","dca","bda","bdca"
        }));
        System.out.println(new Problem1048().longestStrChain(new String[]{
                "ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"
        }));
    }

}
