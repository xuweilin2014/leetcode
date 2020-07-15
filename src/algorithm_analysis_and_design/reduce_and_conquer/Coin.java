package algorithm_analysis_and_design.reduce_and_conquer;

public class Coin {

    public static void main(String[] args) {
        System.out.println(findFakeCoin(new int[]{2, 2, 2, 2, 2, 2, 2,2,1,2,2,}));
    }

    public static int findFakeCoin(int[] nums){
        return doFindFakeCoin(nums, 0, nums.length - 1);
    }

    public static int doFindFakeCoin(int[] nums, int left, int right){
        int weight1 = 0, weight2 = 0;
        int num;
        int len = right - left + 1;

        if (left == right)
            return left;

        if (len % 3 == 0){
            num = len / 3;
        }else{
            num = len / 3 + 1;
        }

        for (int i = 0; i < num; i++) {
            weight1 += nums[left + i];
            weight2 += nums[left + num + i];
        }

        if (weight1 == weight2){
            return doFindFakeCoin(nums, left + 2 * num, right);
        }else if (weight1 > weight2){
            return doFindFakeCoin(nums, left + num, left + 2 * num - 1);
        }else{
            return doFindFakeCoin(nums, left, left + num - 1);
        }
    }

}
