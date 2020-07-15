package algorithm_analysis_and_design.reduce_and_conquer;

public class HeapSort {

    public static void main(String[] args) {
        int[] ints = {28, 35, 20, 32, 18, 12};
        heapSort(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }

    public static void heapSort(int[] nums){
        if (nums.length == 1)
            return;
        // 将无序数列创建为大根堆
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            siftHeap(nums, nums.length, i);
        }
        // 重复进行移走堆顶以及重建堆的操作
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[nums.length - i];
            nums[nums.length - i] = nums[0];
            nums[0] = temp;
            // 只需要调整根结点
            siftHeap(nums, nums.length - i, 0);
        }
    }

    public static void siftHeap(int[] nums, int len, int k){
        int j =  2 * k + 1;
        while (j < len){
            // 比较左子节点和右子节点的大小
            if (j < len - 1 && nums[j] < nums[j+1])
                j++;
            if (nums[k] > nums[j])
                break;
            else{
                int temp = nums[k];
                nums[k] = nums[j];
                nums[j] = temp;
                k = j;
                j = 2 * k + 1;
            }
        }
    }

}
