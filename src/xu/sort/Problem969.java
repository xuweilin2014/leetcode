package xu.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 本题的基本思路是：我们可以将最大的元素（在位置i）进行煎饼翻转i操作，使得它位于序列的最前面（也就是
 * 位置0），然后再进行煎饼翻转 A.length 操作，使得它位于序列的最后面。这个时候，最大的元素就位于正确
 * 的位置上了。我们可以重复这个过程一直到序列全部被排好序。
 */

public class Problem969 {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> ans = new ArrayList<>();
        int counter = 0;
        int index = A.length - 1;
        while (counter < A.length - 1){
            int maxIndex = getMaxIndex(A, index);
            if (index != maxIndex) {
                if (maxIndex != 0) {
                    ans.add(maxIndex + 1);
                    pancake(A, maxIndex + 1);
                }
                ans.add(index + 1);
                pancake(A, index + 1);
            }
            counter++;
            index--;
        }

        return ans;
    }

    public int getMaxIndex(int[] A, int bound){
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i <= bound; i++) {
            if (A[i] > max){
                max = A[i];
                index = i;
            }
        }
        return index;
    }

    public void pancake(int[] A, int span){
        int high = span - 1;
        int low = 0;
        while (low < high) {
            int tmp = A[high];
            A[high] = A[low];
            A[low] = tmp;
            high--;
            low++;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problem969().pancakeSort(new int[]{3,2,4,1}));
    }
}
