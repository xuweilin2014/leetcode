package offer.question31_40;

public class Question33 {

    public static void main(String[] args) {
        System.out.println(VerifySquenceOfBST(new int[]{4,6,12,8,16,14,10}));
    }

    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0)
            return true;

        return doVerify(sequence, 0, sequence.length - 1);
    }

    // sequence[right] 表示树的根节点，假设 left...i-1 表示左子树，i...right-1 表示右子树
    // 简单来说，就是通过循环判断左子树中的值都比根节点的值小，而右子树的值都比根节点的值大（当然，可能树本身不存在左子树或者右子树）
    public static boolean doVerify(int[] sequence, int left, int right){
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

        return doVerify(sequence, left, i - 1)
                && doVerify(sequence, i, right - 1);
    }

}
