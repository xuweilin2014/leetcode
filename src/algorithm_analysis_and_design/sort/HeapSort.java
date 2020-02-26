package algorithm_analysis_and_design.sort;

public class HeapSort {

    public void heapSort(int[] vals){
        for (int i = vals.length/2 - 1; i >= 0; i--) {
            heapAdjust(vals, i, vals.length - 1);
        }
        for (int i = vals.length - 1; i > 0; i--) {
            int tmp = vals[i];
            vals[i] = vals[0];
            vals[0] = tmp;
            heapAdjust(vals, 0, i - 1);
        }
    }

    private void heapAdjust(int[] vals, int s, int m) {
        int key = vals[s];
        int j;
        if (s == 0)
            j = s + 1;
        else
            j = 2 * s;
        while (j <= m){
            if (j < m && vals[j] < vals[j+1])
                j++;
            if (key > vals[j])
                break;
            vals[s] = vals[j];
            s = j;
            j *= 2;
        }
        vals[s] = key;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{49,38,65,97,76,13,27,49};
        new HeapSort().heapSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
