package xu.sort;

import java.util.*;

public class Problem179 {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(String.valueOf(nums[i]));
        }
        Collections.sort(list, new LargeNumberComparator());
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            if ("0".equals(s) && sb.toString().equals("0"))
                continue;
            sb.append(s);
        }
        return sb.toString();
    }

    private class LargeNumberComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            String s1 = o1 + o2;
            String s2 = o2 + o1;
            if (s1.compareTo(s2) > 0)
                return -1;
            else
                return 1;
        }
    }


    public static void main(String[] args) {
        System.out.println(new Problem179().largestNumber(new int[]{3,30,34,5,9}));
    }
}
