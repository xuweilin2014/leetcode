package offer.question21_30.questions;

import java.util.Stack;

public class Question30 {

    private Stack<Integer> stack = new Stack<>();

    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (!minStack.isEmpty()){
            minStack.push(Math.min(minStack.peek(), node));
        }else {
            minStack.push(node);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        Question30 q = new Question30();
        q.push(-10);
        q.push(14);
        System.out.println(q.min());
        System.out.println(q.min());
        q.push(-20);
        System.out.println(q.min());
        System.out.println(q.min());
        System.out.println(q.top());
        System.out.println(q.min());
        q.pop();
        q.push(10);
        q.push(-7);
        System.out.println(q.min());
        q.push(-7);
        q.pop();
        System.out.println(q.top());
        System.out.println(q.min());
        q.pop();
    }

}
