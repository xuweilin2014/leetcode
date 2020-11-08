package xu.two_pointer;

import algorithm_analysis_and_design.divide_and_conquer.MaxSubSum;
import xu.stack.Problem42;

public class Problem424 {

    public int characterReplacement(String s, int k) {
        char[] chs = s.toCharArray();
        int[] alpha = new int[26];
        int low = 0;
        int high = 0;
        // 当前滑动窗口内出现次数最多的字符的个数
        int maxWindowCharCount = 0;
        int maxWinLen = 0;

        for (high = 0; high < chs.length; high++) {
            int index = chs[high] - 'A';
            alpha[index]++;
            maxWindowCharCount = getMax(alpha, chs, low, high);
            if (high - low + 1 > maxWindowCharCount + k){
                alpha[chs[low] - 'A']--;
                low++;
            }else {
                maxWinLen = Math.max(maxWinLen, high - low + 1);
            }
        }

        return maxWinLen;
    }

    private int getMax(int[] alpha, char[] chs, int low, int high) {
        int maxChar = 0;
        for (int i = low; i <= high; i++) {
            maxChar = Math.max(maxChar, alpha[chs[i] - 'A']);
        }

        return maxChar;
    }

    public static void main(String[] args) {
        System.out.println(new Problem424().characterReplacement("ABAB", 2)); // 4
        System.out.println(new Problem424().characterReplacement("AABABBA", 1)); // 4
        System.out.println(new Problem424().characterReplacement("CABCBDA", 1)); // 3
        System.out.println(new Problem424().characterReplacement("CA", 1)); // 2
        System.out.println(new Problem424().characterReplacement("E", 1)); // 1
        System.out.println(new Problem424().characterReplacement("ECH", 1)); // 2
        System.out.println(new Problem424().characterReplacement("ECH", 3)); // 3
        System.out.println(new Problem424().characterReplacement("BAAA", 0)); // 3
        System.out.println(new Problem424().characterReplacement("ECH", 0)); // 1
        System.out.println(new Problem424().characterReplacement("BAAA", 2)); // 4
    }

}
