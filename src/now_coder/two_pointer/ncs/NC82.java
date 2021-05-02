package now_coder.two_pointer.ncs;

import java.util.*;

public class NC82 {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        if (num == null || num.length == 0 || num.length < size || size == 0)
            return new ArrayList<>();

        Deque<Integer> queue = new ArrayDeque<>(size);
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            while (!queue.isEmpty() && num[i] > queue.peekLast())
                queue.pollLast();
            queue.offerLast(num[i]);
        }

        for (int i = 1; i < num.length - size + 1; i++) {
            ans.add(queue.peekFirst());
            if (queue.peekFirst() == num[i - 1])
                queue.pollFirst();
            while (!queue.isEmpty() && num[i + size - 1] > queue.peekLast())
                queue.pollLast();
            queue.offerLast(num[i + size - 1]);
        }

        if (!queue.isEmpty())
            ans.add(queue.peekFirst());

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new NC82().maxInWindows(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3));
    }

}
