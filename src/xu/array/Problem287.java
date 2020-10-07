package xu.array;

/**
 * 将数组看成是一个链表，在链表中寻找环
 */
public class Problem287 {

    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow != fast);

        fast = 0;
        do{
            slow = nums[slow];
            fast = nums[fast];
        }while (slow != fast);

        return slow;
    }

    public static void main(String[] args) {
        System.out.println(new Problem287().findDuplicate(new int[]{2,5,9,6,9,3,8,9,7,1}));
    }

}
