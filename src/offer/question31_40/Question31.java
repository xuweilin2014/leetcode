package offer.question31_40;

import java.util.Stack;

public class Question31 {

    public static void main(String[] args) {
        System.out.println(IsPopOrder(new int[]{1,2,3,4,5}, new int[]{1,2,3,4,5}));
        System.out.println(IsPopOrder(new int[]{1,2,3,4,5}, new int[]{5,4,3,2,1}));
        System.out.println(IsPopOrder(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1}));
        System.out.println(IsPopOrder(new int[]{1,2,3,4,5}, new int[]{4,5,3,1,2}));
    }

    // final
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length == 0 || popA.length == 0)
            return true;

        if (pushA.length == 1 && pushA[0] == popA[0])
            return true;

        Stack<Integer> stack = new Stack<>();
        int counter = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && counter < popA.length && stack.peek() == popA[counter]){
                stack.pop();
                counter++;
            }
        }

        return stack.isEmpty();
    }

}
