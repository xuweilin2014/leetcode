package xu.string;

import java.util.*;

public class Problem49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Character, Long> alpha = new HashMap<>();
        Map<Long, List<String>> map = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            alpha.put((char) ('a' + i), new Random().nextLong());
        }

        for (String str : strs) {
            long id = getIdentity(str, alpha);
            if (map.containsKey(id)){
                map.get(id).add(str);
            }else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(id, list);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Long, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }

        return res;
    }

    private long getIdentity(String string, Map<Character, Long> alpha){
        long res = 0;
        for (char ch : string.toCharArray()) {
            res += alpha.get(ch);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Problem49().groupAnagrams(new String[]{"ape","pea","tax"}));
        System.out.println(new Problem49().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        for (int i = 0; i < 26; i++) {
            System.out.println(new Random().nextLong());
        }
    }


}
