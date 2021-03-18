package offer.question31_40.solutions;

import java.util.Stack;

public class QSolution31 {

    /*
     * 栈的压入、弹出序列
     *
     * 这道题目可以使用一个栈来解决，遍历 pushed 数组，将每一个元素压入栈，然后判断栈的顶点坐标和 popped[j] 是否
     * 相同，如果相同的话，就将栈顶元素弹出，并且 j++，然后再进行判断。最后 pushed 数组的元素遍历完成之后，判断
     * j 是否也同样到达了 popped 数组的尾端。如果是的话，说明 stack 栈中的元素全部弹出。
     */

    // final
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

}
