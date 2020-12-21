package xu.greedy.problems;

/**
 * 从后往前遍历，如果某一个元素可以跳到末尾，那么往前遍历时就直接判断前面的节点是否可以到达此元素，如不行，则将
 * 距离加一，判断前面的节点是否大于新的距离
 */
public class Problem55 {

    public boolean canJump(int[] nums) {
        if (nums.length == 1)
            return true;

        int len = nums.length;
        int distance = len;
        for (int i = len - 2; i > 0; i--) {
            if (nums[i] >= getDistance(i, distance))
                distance = i + 1;
        }

        if (nums[0] >= getDistance(0, distance))
            return true;
        else
            return false;
    }

    private int getDistance(int val, int distance){
        return distance - val - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Problem55().canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(new Problem55().canJump(new int[]{2,3,1,1,4}));
        System.out.println(new Problem55().canJump(new int[]{10, 2, 1, 0, 4}));
        System.out.println(new Problem55().canJump(new int[]{2,1,5,0,0,4}));
        System.out.println(new Problem55().canJump(new int[]{2,0,2,0,1,4}));
    }

}
