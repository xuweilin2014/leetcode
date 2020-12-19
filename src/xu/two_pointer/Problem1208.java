package xu.two_pointer;

public class Problem1208 {

    public int equalSubstring(String s, String t, int maxCost) {
        int low = 0;
        int high;
        int prefix = 0;
        int maxWinLen = 0;

        for (high = 0; high < t.length(); high++) {
            prefix += Math.abs(s.charAt(high) - t.charAt(high));

            if (prefix > maxCost){
                prefix -= Math.abs(s.charAt(low) - t.charAt(low));
                low++;
            }else {
                maxWinLen = Math.max(maxWinLen, high - low + 1);
            }
        }

        return maxWinLen;
    }

    public static void main(String[] args) {
        System.out.println(new Problem1208().equalSubstring("abcd", "bcdf", 3)); // 3
        System.out.println(new Problem1208().equalSubstring("abcd", "cdef", 3)); // 1
        System.out.println(new Problem1208().equalSubstring("abcd", "acde", 0)); // 1
        System.out.println(new Problem1208().equalSubstring("krrgw", "zjxss", 19)); // 1


    }

}
