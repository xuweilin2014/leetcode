package xu.sort;

/**
 * 荷兰国旗问题，基本思想是将数组分成3个部分，因此，我们设置3个标志位：
 * begin指向这个数组的开始
 * end指向这个数组的末尾
 * current标志位从头开始进行遍历
 */

public class Problem75 {
    public void sortColors(int[] nums) {
        int cur = 0;
        int begin = 0;
        int end = nums.length - 1;
        while (cur <= end){
            if (nums[cur] == 0){
                swap(nums, cur, begin);
                cur++;
                begin++;
            }else if (nums[cur] == 1){
                cur++;
            }else{
                swap(nums, cur, end);
                end--;
            }
        }
    }

    public void swap(int[] nums, int index1, int index2){
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    public static void main(String[] args) {
        int[] vals = new int[]{2,0,1};
        new Problem75().sortColors(vals);
        for (int j = 0; j < vals.length; j++) {
            System.out.print(vals[j] + " ");
        }
    }
}
