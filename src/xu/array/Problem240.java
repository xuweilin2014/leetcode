package xu.array;

/**
 * 和剑指offer上的第4题类似，都是从矩阵的右上角开始遍历，当矩阵的值恰好等于target时，返回true，
 * 当矩阵的值小于target时，则向下一行进行搜索；当矩阵的值大于target时，则向左边的列进行搜索
 */
public class Problem240 {

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        }, 25));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = cols - 1; j >= 0; j--) {
                if (matrix[i][j] == target)
                    return true;
                else if (matrix[i][j] < target) {
                    break;
                }else{
                    cols--;
                }
            }
        }

        return false;
    }

}
