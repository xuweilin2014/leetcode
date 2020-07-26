package xu.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/**
 * 725. Split Linked List in Parts
 */
public class Problem725 extends SinglyLinkedListUtil {

    public static ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] results = new ListNode[k];

        if (root == null)
            return results;

        List<ListNode> nodes = new ArrayList<>();
        ListNode node = root;
        long len = 0;

        while (node != null){
            nodes.add(node);
            node = node.next;
            len++;
        }

        List<Integer> splitIndex = getSplitIndex(len, k);

        results[0] = root;
        for (int i = 0; i < splitIndex.size(); i++) {
            ListNode next = nodes.get(splitIndex.get(i) - 1).next;
            if (i + 1 < splitIndex.size()){
                results[i + 1] = next;
            }
            nodes.get(splitIndex.get(i) - 1).next = null;
        }

        return results;

    }

    public static List<Integer> getSplitIndex(long len, int k){
        List<Integer> arrs = new ArrayList<>();
        int sum = 0;
        while (len != 0){
            long tmp = 0;
            if (len % k == 0){
                tmp = len / k;
            }else{
                tmp = len / k + 1;
            }
            sum += tmp;
            arrs.add(sum);
            len -= tmp;
            k--;
        }

        return arrs;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        Problem725.addNode(head, 2, 0);
        Problem725.addNode(head, 3, 0);
        Problem725.addNode(head, 4, 0);
        Problem725.addNode(head, 5, 0);
        Problem725.addNode(head, 6, 0);
        Problem725.addNode(head, 7, 0);
        Problem725.addNode(head, 8, 0);
        Problem725.addNode(head, 9, 0);
        Problem725.addNode(head, 10, 0);

        Problem725.printList(head);

        ListNode[] listNodes = Problem725.splitListToParts(null, 5);
        for (ListNode listNode : listNodes) {
            if (listNode == null) {
                System.out.println("null");
                continue;
            }
            Problem725.printList(listNode);
        }

    }

}
