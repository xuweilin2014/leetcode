package offer.question21_30.solutions;

public class QSolution29 {
    /*
     * 顺时针打印矩阵
     *
     * 这道题目使用递归来进行解答，每一层递归对矩阵中的某一层进行遍历。
     * 比如第一层是：(row, col, rows, cols, matrix)
     * 那么第二层是：(row + 1, rol + 1, rows - 2, cols - 2, matrix)
     * 其中，row 和 col 表示的是每一层开始坐标
     *
     * 在每一层遍历的时候，进行分四个阶段进行遍历：
     * 1.最上面从左到右进行遍历
     * 2.最左边从上到下进行遍历
     * 3.最下面从右往左进行遍历
     * 4.最左边从下到上进行遍历
     *
     * 在分四个阶段进行遍历之后，基本上可以覆盖大部分情况，但是还有两个特殊情况，就是只有一行或者
     * 只有一列。
     * a.只有一行时，这时就不需要进行上面的第 3 个阶段
     * b.只有一列时，这时就不需要进行上面的第 4 个阶段
     */

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[]{};

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] nums = new int[rows * cols];

        func(matrix, rows, cols, nums, 0,0,0);

        return nums;
    }

    private void func(int[][] matrix, int rows, int cols, int[] nums, int index, int row, int col) {
        if (rows <= 0 || cols <= 0)
            return;

        for (int i = 1; i <= cols; i++) {
            nums[index++] = matrix[row][col++];
        }
        col--;
        row++;

        for (int i = 1; i < rows; i++) {
            nums[index++] = matrix[row++][col];
        }
        row--;
        col--;

        for (int i = 1; i < cols && rows > 1; i++) {
            nums[index++] = matrix[row][col--];
        }
        col++;
        row--;

        for (int i = 1; i < rows - 1 && cols > 1; i++) {
            nums[index++] = matrix[row--][col];
        }

        func(matrix, rows - 2, cols - 2, nums, index, row + 1, col + 1);
    }
}
