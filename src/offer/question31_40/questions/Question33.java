package offer.question31_40.questions;

public class Question33 {

    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0)
            return true;

        return func(postorder, 0, postorder.length - 1);
    }

    private boolean func(int[] postorder, int low, int high) {
        if (low >= high)
            return true;

        int root = postorder[high];
        int index = low - 1;
        for (int i = high - 1; i >= low; i--) {
            if (postorder[i] < root && index == low - 1)
                index = i;
            if (postorder[i] > root && i < index)
                return false;
        }

        return func(postorder, low, index) && func(postorder, index + 1, high - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Question33().verifyPostorder(new int[]{5,2,-17,-11,25,76,62,98,92,61}));
        System.out.println(new Question33().verifyPostorder(new int[]{4,6,12,8,16,14,10}));
        System.out.println(new Question33().verifyPostorder(new int[]{1,6,3,2,5}));
        System.out.println(new Question33().verifyPostorder(new int[]{1,3,2,6,5}));
        System.out.println(new Question33().verifyPostorder(new int[]{1,2,4,5}));
    }

}
