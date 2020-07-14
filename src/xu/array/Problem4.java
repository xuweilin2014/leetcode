package xu.array;

/**
 * 这道题可以转化成寻找两个有序数组中的第 k 小的数
 *
 * 假设两个有序数组为A和B（假设第一个元素的索引为1），那么我们可以归纳出以下三种情况：
 * 1.如果 A 的第 k/2 个数 < B 的第 k/2 个数，则比 A 的第 k/2 个数小的数最多只有 A 的前 k/2−1 个数和 B 的前 k/2−1 个数，
 * 即比 A 的第 k/2 个数 小的数最多只有 k-2 个，因此 A 的第 k/2 个数不可能是第 k 个数，对于 A 数组，则从第1个数到第k/2个数，都可以
 * 排除掉
 * 2.如果 A 的第 k/2 个数 > B 的第 k/2 个数，那么排除掉 B 的第 1 个数到 k/2 个数
 * 3.如果 A 的第 k/2 个数 = B 的第 k/2 个数，那么可以按照第 1 种情况处理
 *
 * 特殊情况或者说边界情况有以下3种:
 * 1.数组越界
 * 2.数组为空
 * 3.k = 1
 */
public class Problem4 {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 2, 3, 4, 5}, new int[]{5, 6, 7, 8, 9}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int median1 = (nums1.length + nums2.length + 1) / 2;
        int median2 = (nums1.length + nums2.length + 2) / 2;

        return (getKthNumber(nums1, nums2, median1)
                + getKthNumber(nums1, nums2, median2)) / 2.0;
    }

    public static int getKthNumber(int[] nums1, int[] nums2, int k){
        int p1 = 0, p2 = 0;
        int len1 = 0, len2 = 0;

        while (true){
            p1 = len1 + Math.max(0, k / 2 - 1);
            p2 = len2 + Math.max(0, k / 2 - 1);

            if (len1 == nums1.length)
                return nums2[k + len2 - 1];

            if (len2 == nums2.length)
                return nums1[k + len1 - 1];

            if (k == 1)
                return Math.min(nums1[p1], nums2[p2]);

            if (p1 > nums1.length - 1){
                p1 = nums1.length - 1;
            }

            if (p2 > nums2.length - 1){
                p2 = nums2.length - 1;
            }

            if (nums1[p1] >= nums2[p2]){
                k -= (p2 + 1 - len2);
                len2 = p2 + 1;
            }else if (nums1[p1] < nums2[p2]){
                k -= (p1 + 1 - len1);
                len1 = p1 + 1;
            }
        }
    }

}
