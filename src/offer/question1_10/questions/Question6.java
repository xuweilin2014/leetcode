package offer.question1_10.questions;

import xu.linkedlist.problems.ListNode;
import xu.linkedlist.problems.SinglyLinkedListUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Question6 {

    private ArrayList<Integer> ans = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null)
            return ans;

        func(listNode);
        return ans;
    }

    private void func(ListNode node) {
        if (node.next == null){
            ans.add(node.val);
            return;
        }

        func(node.next);
        ans.add(node.val);
    }

    public static void main(String[] args) {
        ListNode node = SinglyLinkedListUtil.buildLinkedList(new int[]{1, 2, 3, 4});
        System.out.println(new Question6().printListFromTailToHead(node));
    }
}
