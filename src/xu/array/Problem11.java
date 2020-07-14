package xu.array;

/**
 * 盛水最多的容器，使用双指针法可以解决
 */
public class Problem11 {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public static int maxArea(int[] height) {
        int area = 0;
        int l = 0, r = height.length - 1;
        while (l < r){
            int tmp = Math.min(height[l], height[r]) * (r - l);
            if (tmp > area){
                area = tmp;
            }

            if (height[l] < height[r])
                l++;
            else
                r--;
        }

        return area;
    }

}
