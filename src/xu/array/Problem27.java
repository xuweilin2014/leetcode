package xu.array;

public class Problem27 {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        int len = removeElement(nums, 3);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        int l = 0, r = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                l = i;
                r = i;
                break;
            }
        }

        while (r < nums.length){
            while (r < nums.length && nums[r] == val) {
                len--;
                r++;
            }


            if (r < nums.length)
                nums[l++] = nums[r++];
        }

        return len;
    }

}
