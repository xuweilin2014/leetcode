package xu.stack;

import java.util.Stack;

/**
 * 使用一个栈，对字符串从左往右进行扫描。可能有两种情况：
 *
 * 情况一：token 是数字，则直接把 token 加入到栈中
 * 情况二：token 是 #，则需要根据栈顶元素来进行下一步操作：
 * 1.若栈顶元素为 #，则在循环中不断弹出栈顶元素 #，弹出栈顶的数字，直到栈顶元素不为 #
 * 2.若栈顶元素不为 #，则直接把 token加入到栈中
 *
 * 最后检查栈中元素是否只有一个，并且栈顶元素为 #
 */

public class Problem331 {
    public boolean isValidSerialization(String preorder) {
        String[] tokens = preorder.split(",");
        Stack<String> stack = new Stack<>();

        /**
         * when you iterate through the preorder traversal string, for each char:
         *
         * case 1: you see a number c, means you begin to expand a new tree rooted with c, you push it to stack
         * case 2.1: you see a #, while top of stack is a number, you know this # is a left null child,
         * put it there as a mark for next coming node k to know it is being the right child.
         * case 2.2： you see a #, while top of stack is #, you know you meet this # as right null child,
         * you now cancel the sub tree (rooted as t, for example) with these two-# children.
         * But after the cancellation, you continue to check top of stack is whether # or a number:
         *
         * ---- if a number, you know you just cancelled a node t which is left child of u.
         * You need to leave a # mark to the top of stack. So that the next node know it is a right child.
         * ---- if a #, you know you just cancelled a tree whose root, t, is the right child of u.
         * So you continue to cancel sub tree of u, and the process goes on and on.
         */
        for (String token : tokens) {
            if (token.equals("#")){
                while (!stack.isEmpty() && stack.peek().equals("#")){
                    stack.pop();
                    if (stack.isEmpty())
                        return false;
                    stack.pop();
                }
            }
            stack.push(token);
        }

        return stack.size() == 1 && stack.peek().equals("#");
    }

    public static void main(String[] args) {
        System.out.println(new Problem331().isValidSerialization("#,#"));
    }
}
