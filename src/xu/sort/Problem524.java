package xu.sort;

import java.util.*;

public class Problem524 {
    public String findLongestWord(String s, List<String> d) {
        char[] chars = s.toCharArray();
        List<String> list = new ArrayList<>();
        int maxLen = 0;
        for (String str : d) {
            char[] ch = str.toCharArray();
            if (isContained(chars, ch)){
                if (ch.length == maxLen){
                    list.add(str);
                }else if (ch.length > maxLen){
                    maxLen = ch.length;
                    list.clear();
                    list.add(str);
                }
            }
        }

        Collections.sort(list);
        return list.size() > 0 ? list.get(0) : "";
    }

    private boolean isContained(char[] chars, char[] ch) {
        int low = 0;
        int high = 0;
        while (low < ch.length && high < chars.length){
            if (ch[low] != chars[high]) {
                high++;
            }else{
                high++;
                low++;
            }
        }
        return low == ch.length;
    }

    public static void main(String[] args) {
        List<String> array = new ArrayList<>();
        array.add("apple");
        array.add("ewaf");
        array.add("awefawfwaf");
        array.add("awef");
        array.add("awefe");
        array.add("ewafeffewafewf");
        System.out.println(new Problem524().findLongestWord("aewfafwafjlwajflwajflwafj", array));
    }
}
