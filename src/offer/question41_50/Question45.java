package offer.question41_50;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Question45 {

    public String minNumber(int[] nums) {
        List<String> arr = new ArrayList<>();
        for (int num : nums) {
            arr.add(String.valueOf(num));
        }

        arr.sort((o1, o2) -> {
            long val1 = Long.parseLong(o1 + o2);
            long val2 = Long.parseLong(o2 + o1);

            if ((val1 - val2) > 0)
                return 1;
            else if ((val1 - val2) < 0)
                return -1;
            else
                return 0;
        });

        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Question45().minNumber(new int[]{999999998,999999997,999999999}));
    }

}
