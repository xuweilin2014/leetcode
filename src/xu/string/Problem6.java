package xu.string;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {

    public static void main(String[] args) {
        System.out.println(convert("AABC", 3));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1)
            return s;

        char[] chs = s.toCharArray();
        List<List<Character>> lists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            lists.add(new ArrayList<>());
        }

        int counter = 0;
        int rows = numRows * 2 - 2;

        while (counter < chs.length){
            if (counter % rows == 0){
                int i = 0;
                while (i < numRows && counter < chs.length){
                    lists.get(counter % rows).add(chs[counter]);
                    counter++;
                    i++;
                }
                continue;
            }

            lists.get(rows - (counter % rows)).add(chs[counter]);
            counter++;
        }

        StringBuilder sb = new StringBuilder();
        for (List<Character> list : lists) {
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
            }
        }

        return sb.toString();
    }

}
