package xu.greedy;

import java.util.HashMap;
import java.util.Map;

public class Problem659 {

    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> ends = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            Integer times = map.getOrDefault(num, 0);
            if (times == 0){
                continue;
            }else if (ends.getOrDefault(num - 1, 0) > 0){
                ends.put(num, ends.getOrDefault(num, 0) + 1);
                ends.put(num - 1, ends.get(num - 1) - 1);
                map.put(num, map.get(num) - 1);
            }else if (map.getOrDefault(num + 1, 0) > 0 && map.getOrDefault(num + 2, 0) > 0){
                ends.put(num + 2, ends.getOrDefault(num + 2, 0) + 1);
                map.put(num + 1, map.getOrDefault(num + 1, 0) - 1);
                map.put(num + 2, map.getOrDefault(num + 2, 0) - 1);
                map.put(num, map.getOrDefault(num, 0) - 1);
            }else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Problem659().isPossible(new int[]{1, 2, 3, 3, 4, 5}));
        System.out.println(new Problem659().isPossible(new int[]{1,2,3,3,4,4,5,5}));
        System.out.println(new Problem659().isPossible(new int[]{1,2,3,4,4,5}));
    }

}
