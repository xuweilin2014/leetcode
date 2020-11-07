package xu.hashtable;

import java.util.*;

public class Problem438 {

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Double> alpha = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        if (s == null || s.length() == 0 || s.length() < p.length())
            return res;

        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            if (!alpha.containsKey(ch)){
                alpha.put(ch, (double) (new Random().nextInt(1000) + (ch - 'a')));
            }
        }

        double partSum = 0;
        double target = 0;
        for (int i = 0; i < p.length(); i++) {
            partSum += alpha.get(s.charAt(i));
            target += alpha.get(p.charAt(i));
        }

        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length - p.length() + 1; i++) {
            if (i > 0){
                partSum -= alpha.get(s.charAt(i - 1));
                partSum += alpha.get(s.charAt(i + p.length() - 1));
            }
            if (partSum == target){
                res.add(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Problem438().findAnagrams("cbaebabacd", "abc"));
        System.out.println(new Problem438().findAnagrams("abab", "ab"));
        System.out.println(new Problem438().findAnagrams("aaaaaaaaaa", "aaaaaaaaaaaaa"));
    }

}
