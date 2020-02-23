package xu.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem1333 {

    static class RSComparator implements Comparator<int[]>{

        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[1] == o2[1]) {
                return o2[0] - o1[0];
            }
            else{
                return o2[1] - o1[1];
            }

        }
    }

    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int[]> list = new ArrayList<>();
        for (int[] restaurant : restaurants) {
            if (veganFriendly == 1 && restaurant[2] == 0)
                continue;
            if (restaurant[3] > maxPrice)
                continue;
            if (restaurant[4] > maxDistance)
                continue;
            list.add(new int[]{restaurant[0], restaurant[1]});
        }
        Collections.sort(list, new RSComparator());
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            ans.add(list.get(i)[0]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Problem1333().filterRestaurants(new int[][]{
                {1, 4, 1, 40, 10}, {2, 9, 1, 50, 5},
                {3, 8, 1, 30, 4}, {4, 10, 1, 10, 3}, {5, 1, 1, 15, 1}
        }, 1, 50, 10));
    }
}
