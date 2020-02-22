package xu.sort;

import java.util.HashMap;
import java.util.Map;

/**
 * 本题的基本思想是：对这些车辆按照他们的起始位置进行升序排序，然后用公式 (target - position[i]) / speed[i] 计算出
 * 每辆车在不受其它车辆影响的情况下，行驶到目的地所需要的时间。对于相邻的两辆车 S 和 F，如果 F 的起始距离大于
 * S 的起始距离，如果 S 到达终点的时间小于F，则 S 与 F 会形成车队。
 *
 * 具体做法是：在升序排序后，进行遍历求解时，需要从后往前进行遍历
 */

public class Problem853 {
    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 0)
            return 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < position.length; i++) {
            map.put(position[i], speed[i]);
        }
        sort(position, 0, position.length - 1);
        double[] times = new double[position.length];
        for (int i = 0; i < times.length; i++) {
            times[i] = (target - position[i]) / (double) map.get(position[i]);
        }
        int fleet = 0;
        int k = position.length - 1;
        while (k > 0){
            if (times[k-1] > times[k])
                fleet++;
            else
                times[k-1] = times[k];
            k--;
        }

        return fleet + 1;
    }

    private void sort(int[] arr, int begin, int end) {
        if (begin < end){
            int i = begin;
            int j = end;
            int key = arr[begin];
            while (i < j){
                while (i < j && arr[j] > key)
                    j--;
                if (i < j){
                    arr[i] = arr[j];
                    i++;
                }
                while (i < j && arr[i] < key)
                    i++;
                if (i < j){
                    arr[j] = arr[i];
                    j--;
                }
            }
            arr[i] = key;
            sort(arr, begin, i - 1);
            sort(arr, i + 1,  end);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problem853().carFleet(10,
                new int[]{0,2,4}, new int[]{2,3,1}));
    }
}
