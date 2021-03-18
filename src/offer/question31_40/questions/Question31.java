package offer.question31_40.questions;

import java.util.Stack;

public class Question31 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0)
            return true;

        Stack<Integer> stack = new Stack<>();
        int j = 0;

        for (int num : pushed) {
            stack.push(num);
            while (j < popped.length && !stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }

        return j == popped.length;
    }

    public static void main(String[] args) {
        System.out.println(new Question31().validateStackSequences(new int[]{1,2,3,4,5}, new int[]{1,2,3,4,5}));
        System.out.println(new Question31().validateStackSequences(new int[]{1,2,3,4,5}, new int[]{5,4,3,2,1}));
        System.out.println(new Question31().validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1}));
        System.out.println(new Question31().validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,5,3,1,2}));
    }

}
