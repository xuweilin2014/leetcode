package xu.linkedlist;

import java.awt.*;

class Node extends ListNode {

    Node random;

    Node(int val){
        super(val);
        this.random = null;
        this.next = null;
    }

}
