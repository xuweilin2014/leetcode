package offer.question31_40.questions;

import java.util.Stack;

public class Question31 {

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length != popA.length)
            return false;

        int counter = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= pushA.length; i++) {
            while (!stack.isEmpty() && stack.peek() == popA[counter]){
                stack.pop();
                counter++;
            }

            if (i < pushA.length){
                int val = pushA[i];
                stack.push(val);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Question31().IsPopOrder(new int[]{1,2,3,4,5}, new int[]{1,2,3,4,5}));
        System.out.println(new Question31().IsPopOrder(new int[]{1,2,3,4,5}, new int[]{5,4,3,2,1}));
        System.out.println(new Question31().IsPopOrder(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1}));
        System.out.println(new Question31().IsPopOrder(new int[]{1,2,3,4,5}, new int[]{4,5,3,1,2}));
    }

}
