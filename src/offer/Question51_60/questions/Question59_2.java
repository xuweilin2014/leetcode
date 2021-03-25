package offer.Question51_60.questions;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 普通队列 + 双端队列
 */
public class Question59_2 {

    private Deque<Integer> deque;

    private Queue<Integer> queue;

    public Question59_2() {
        this.deque = new LinkedList<>();
        this.queue = new LinkedList<>();
    }

    public int max_value() {
        if (queue.isEmpty())
            return -1;
        return deque.getFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!deque.isEmpty() && deque.getLast() < value)
            deque.removeLast();
        deque.addLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty())
            return -1;
        int value = queue.poll();
        if (value == deque.getFirst())
            deque.removeFirst();
        return value;
    }

    public static void main(String[] args) {
        Question59_2 q = new Question59_2();
        /*q.push_back(1);
        q.push_back(2);*/
        System.out.println(q.max_value());
        System.out.println(q.pop_front());
        System.out.println(q.max_value());
    }

}
