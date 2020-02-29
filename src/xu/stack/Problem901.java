package xu.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

public class Problem901 {

    static class Pair{
        int val;
        int index;

        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    private Stack<Pair> stack = new Stack<>();

    public Problem901() {
    }

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek().val <= price) {
            span += stack.pop().index;
        }
        stack.push(new Pair(price, span));
        return span;
    }

    public static void main(String[] args) {
        Problem901 p = new Problem901();
        System.out.println(p.next(100));
        System.out.println(p.next(80));
        System.out.println(p.next(60));
        System.out.println(p.next(70));
        System.out.println(p.next(60));
        System.out.println(p.next(75));
        System.out.println(p.next(85));
    }
}
