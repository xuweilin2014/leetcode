package xu.two_pointer.problems;

public class Problem1004 {

    public int longestOnes(int[] A, int K) {
        int counter = K;
        int low = 0;
        int high = 0;
        int maxLen = A[low] == 1 ? 1 : 0;

        while (low < A.length && high < A.length){
            if (A[high] == 0){
                if (counter == 0){
                    maxLen = Math.max(maxLen, high - low);
                    low++;
                    if (A[low - 1] == 1){
                        while (low < A.length && A[low] == 1)
                            low++;
                        if (low < A.length && A[low] == 0)
                            low++;
                    }
                    counter++;
                }else {
                    counter--;
                    high++;
                }
            }else {
                high++;
            }
        }

        return Math.max(maxLen, high - low);
    }

    public static void main(String[] args) {
        System.out.println(new Problem1004().longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
        System.out.println(new Problem1004().longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println(new Problem1004().longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 0));
        System.out.println(new Problem1004().longestOnes(new int[]{1}, 0));
        System.out.println(new Problem1004().longestOnes(new int[]{0}, 0));
        System.out.println(new Problem1004().longestOnes(new int[]{0}, 1));
        System.out.println(new Problem1004().longestOnes(new int[]{1, 0}, 1));
        System.out.println(new Problem1004().longestOnes(new int[]{0, 0}, 1));
        System.out.println(new Problem1004().longestOnes(new int[]{1, 1}, 0));
    }

}
