package offer.question31_40;

public class Question33 {

    public static void main(String[] args) {
        System.out.println(VerifySquenceOfBST(new int[]{4,6,12,8,16,14,10}));
    }

    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0)
            return false;

        return doVerify(sequence, 0, sequence.length - 1, Integer.MAX_VALUE, true);
    }

    public static boolean doVerify(int[] sequence, int left, int right, int rootVal, boolean isLeft){
        if (left >= right)
            return true;

        int i;
        for (i = left; i < right; i++) {
            if (sequence[i] > sequence[right])
                break;
        }

        for (int j = i; j < right; j++) {
            if (sequence[j] < sequence[right])
                return false;
        }

        return doVerify(sequence, left, i - 1, sequence[right], true)
                && doVerify(sequence, i, right - 1, sequence[right], false);
    }

}
