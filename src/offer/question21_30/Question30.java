package offer.question21_30;

import java.util.Stack;

public class Question30 {

    private static Stack<Integer> stack = new Stack<>();

    private static Stack<Integer> minStack = new Stack<>();

    private static int min = Integer.MAX_VALUE;

    public static void push(int node) {
        minStack.push(Math.min(min, node));
        min = Math.min(min, node);
        stack.push(node);
    }

    public static void pop() {
        if (!stack.isEmpty()){
            stack.pop();
        }
        if (!minStack.isEmpty()){
            minStack.pop();
        }
    }

    public static int top() {
        return stack.peek();
    }

    public static int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        Question30.push(3);
        System.out.println(Question30.min());
        Question30.push(4);
        System.out.println(Question30.min());
        Question30.push(2);
        System.out.println(Question30.min());
        Question30.push(3);
        System.out.println(Question30.min());
        Question30.pop();
        System.out.println(Question30.min());
        Question30.pop();
        System.out.println(Question30.min());
        Question30.pop();
        System.out.println(Question30.min());
        Question30.push(0);
        System.out.println(Question30.min());
    }

}
