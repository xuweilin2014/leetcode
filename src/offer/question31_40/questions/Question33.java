package offer.question31_40.questions;

public class Question33 {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;

        return func(sequence, 0, sequence.length - 1);
    }

    private boolean func(int[] sequence, int low, int high) {
        if (low >= high)
            return true;

        int val = sequence[high];
        int index;

        for (index = high - 1; index >= low; index--) {
            if (sequence[index] < val) {
                break;
            }
        }

        for (int i = index - 1; i >= low ; i--) {
            if (sequence[i] >= val)
                return false;
        }

        return func(sequence, low, index) && func(sequence, index + 1, high - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Question33().VerifySquenceOfBST(new int[]{5,4,3,2,1}));
        System.out.println(new Question33().VerifySquenceOfBST(new int[]{4,6,12,8,16,14,10}));
        System.out.println(new Question33().VerifySquenceOfBST(new int[]{1,6,3,2,5}));
        System.out.println(new Question33().VerifySquenceOfBST(new int[]{1,3,2,6,5}));
        System.out.println(new Question33().VerifySquenceOfBST(new int[]{1,2,4,5}));
    }

}
