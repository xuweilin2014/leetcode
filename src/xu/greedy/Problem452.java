package xu.greedy;

import java.util.*;

public class Problem452 {

    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0)
            return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return Integer.compare(t1[1], t2[1]);
            }
        });

        int counter = 1;
        int[] tmp = points[0];
        for (int i = 1; i < points.length; i++) {
            if ((long) points[i][0] > (long) tmp[1]){
                tmp = points[i];
                counter++;
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        System.out.println(new Problem452().findMinArrowShots(new int[][]{
                {10, 16},{2, 8},{1, 6},{7, 12}
        }));
        System.out.println(new Problem452().findMinArrowShots(new int[][]{
                {1,2},{3,4},{5,6},{7,8}
        }));
        System.out.println(new Problem452().findMinArrowShots(new int[][]{
                {1,2},{2,3},{3,4},{4,5}
        }));
        System.out.println(new Problem452().findMinArrowShots(new int[][]{
                {1,2}
        }));
        System.out.println(new Problem452().findMinArrowShots(new int[][]{
                {1,2},{1,2}
        }));
    }

}
