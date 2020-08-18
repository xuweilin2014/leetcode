package offer.Question51_60;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question58_1 {

    public String reverseWords(String s) {
        if (s == null)
            return null;
        s = s.trim();
        if (s.length() == 0 || " ".equals(s))
            return "";

        List<StringBuilder> sbs = new ArrayList<>();
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            StringBuilder sb = new StringBuilder();
            while (chs[i] == ' ')
                i++;

            while (i < chs.length && chs[i] != ' ')
                sb.append(chs[i++]);

            sbs.add(sb);
        }

        Collections.reverse(sbs);
        StringBuilder res = sbs.get(0);
        for (int i = 1; i < sbs.size(); i++) {
            res.append(" ");
            res.append(sbs.get(i));
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Question58_1().reverseWords("  "));
    }

}
