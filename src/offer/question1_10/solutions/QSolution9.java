package offer.question1_10.solutions;

public class QSolution9 {

    /*
     * 用两个栈实现一个队列
     *
     * 用两个栈 stack1 和 stack2 的先进后出模拟一个队列 queue 的先进先出，再调用 queue#push 方法的时候，将要 val 压入到栈 stack1 中。
     * 举例来说，将 a,b,c 压入 queue 中时，会调用 stack1 的 push 方法，这时 stack1 中的元素值为 [a,b,c]，stack2 为 []。
     * 接着如果调用 queue 的 pop 方法时，需要把 stack1 中的元素出栈，然后保存到 stack2 中，那么 stack2 中的元素值为 [c,b,a]，
     * 这时如果把 stack2 中的元素出栈的话，其顺序就是 a,b,c，即先进先出。假设调用一次 queue#pop 方法，那么 stack2 为 [c,b]，
     * 如果再调用一次 queue#push 方法，压入 4 的话，stack1 就变为 [4]，而 stack2 还是 [c,b]。而接着不断调用 queue#pop 的话，如果
     * stack2 不为空的话，仍然继续对 stack2 中的元素出栈直到 stack2 中的元素为空。当 stack2 中的元素为空时，才会将 stack1 中的
     * 元素出栈，然后入栈到 stack2 中。
     *
     * 总结一下，就是 queue#push 方法直接将元素压入 stack1 中；queue#pop 方法被调用时，如果 stack2 为空，那么就将 stack1 中的元素压入其中，
     * 如果 stack2 不为空，那么就直接将 stack2 中的元素出栈
     */

}
