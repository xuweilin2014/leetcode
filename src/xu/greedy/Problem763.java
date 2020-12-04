package xu.greedy;

import java.util.*;

public class Problem763 {

    public List<Integer> partitionLabels(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.put(ch, i);
        }

        int end = 0, start = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            end = Math.max(end, map.get(ch));
            if (i == end){
                ans.add(end - start + 1);
                start = end + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Problem763().partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(new Problem763().partitionLabels("leetcode"));
        System.out.println(new Problem763().partitionLabels("abc"));
        System.out.println(new Problem763().partitionLabels("xuweilin"));
    }

}
