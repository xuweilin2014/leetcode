package xu.array;

public class Problem581 {

    public int findUnsortedSubarray(int[] nums) {
        if (nums.length < 2)
            return 0;

        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        int low = 0;
        int high = 0;
        int ptr;
        boolean isFirst = true;

        for (ptr = 1; ptr < nums.length; ptr++) {
            if (nums[ptr] < nums[ptr - 1]){
                if (isFirst){
                    low = ptr - 1;
                    isFirst = false;
                }
                high = ptr;
            }
        }

        if (isFirst)
            return 0;

        for (int i = low; i <= high; i++) {
            minVal = Math.min(minVal, nums[i]);
            maxVal = Math.max(maxVal, nums[i]);
        }

        while (low > 0 && nums[low - 1] > minVal)
            low--;

        while (high < nums.length - 1 && nums[high + 1] < maxVal)
            high++;

        return high - low + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Problem581().findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(new Problem581().findUnsortedSubarray(new int[]{2, 5, 7, 2, 13, 6, 9}));
        System.out.println(new Problem581().findUnsortedSubarray(new int[]{12, 5, 7, 2, 13, 6, 1}));
        System.out.println(new Problem581().findUnsortedSubarray(new int[]{1, 2, 3, 4}));
        System.out.println(new Problem581().findUnsortedSubarray(new int[]{1}));
    }



}
