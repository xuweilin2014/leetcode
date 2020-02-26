package xu.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 距离相等的条形码，首先使用 map 来建立 barcodes 中编码和出现频次之间的对应关系。
 * 由于希望将出现频次较高的编码放在新数组的最前面，所以我们使用 PriorityQueue 来建立
 * 一个大根堆。每次从大根堆中取出两个 Pair 对象（两个 Pair 对象的 val 值不同），将其 val
 * 值放入到新数组中，同时将 frequency 值减一，再放回到 PriorityQueue 中，不断重复上面这个过程。
 */

public class Problem1054 {

    static class Pair{
        int val;
        int frequency;

        public Pair(int val, int frequency) {
            this.val = val;
            this.frequency = frequency;
        }
    }

    static class PairComparator implements Comparator<Pair>{
        @Override
        public int compare(Pair o1, Pair o2) {
            return -(o1.frequency - o2.frequency);
        }
    }

    public int[] rearrangeBarcodes(int[] barcodes) {
        PriorityQueue<Pair> queue = new PriorityQueue<>(new PairComparator());
        Map<Integer, Integer> map = new HashMap<>();
        for (int barcode : barcodes) {
            if (map.containsKey(barcode)){
                map.put(barcode, map.get(barcode) + 1);
            }else{
                map.put(barcode, 1);
            }
        }

        int[] ans = new int[barcodes.length];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(new Pair(entry.getKey(), entry.getValue()));
        }

        int counter = 0;
        while (queue.size() > 1){
            Pair pair1 = queue.poll();
            Pair pair2 = queue.poll();
            ans[counter++] = pair1.val;
            ans[counter++] = pair2.val;
            if (pair1.frequency - 1 != 0)
                queue.add(new Pair(pair1.val, pair1.frequency - 1));
            if (pair2.frequency - 1 != 0)
                queue.add(new Pair(pair2.val, pair2.frequency - 1));
        }

        if (queue.size() == 1)
            ans[counter] = queue.poll().val;
        return ans;
    }

    public static void main(String[] args) {
        int[] ints = new Problem1054().rearrangeBarcodes(new int[]{1,1,1,2,2,2});
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }
}
