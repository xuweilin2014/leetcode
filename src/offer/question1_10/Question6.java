package offer.question1_10;

import xu.linkedlist.problems.ListNode;

import java.util.LinkedList;
import java.util.List;

public class Question6 {

    public int[] reversePrint(ListNode head) {
        List<Integer> arr = new LinkedList<>();
        doReverse(head, arr);
        int[] vals = new int[arr.size()];
        for (int i = 0; i < vals.length; i++) {
            vals[i] = arr.get(i);
        }
        return vals;
    }

    public void doReverse(ListNode head, List<Integer> arr){
        if (head == null)
            return;

        doReverse(head.next, arr);
        arr.add(head.val);
    }

}
