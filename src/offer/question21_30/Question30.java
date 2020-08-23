package offer.question21_30;

import java.util.Map;
import java.util.Stack;

public class Question30 {

    private Stack<Integer> stack = new Stack<>();

    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        if (stack.isEmpty()) {
            minStack.push(node);
        }else{
            minStack.push(Math.min(minStack.peek(), node));
        }

        stack.push(node);
    }

    public void pop() {
        if (!stack.isEmpty()){
            stack.pop();
        }
        if (!minStack.isEmpty()){
            minStack.pop();
        }
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
