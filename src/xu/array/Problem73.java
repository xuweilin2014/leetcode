package xu.array;

/**
 * 使用矩阵的第一行和第一列来保存 0 元素的信息
 */
public class Problem73 {

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;

        boolean firstRow = false;
        boolean firstCol = false;

        if (matrix[0][0] == 0){
            firstRow = true;
            firstCol = true;
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row == 0 && !firstRow){
                    if (matrix[row][col] == 0){
                        firstRow = true;
                        continue;
                    }
                }

                if (col == 0 && !firstCol){
                    if (matrix[row][col] == 0){
                        firstCol = true;
                        continue;
                    }
                }

                if (matrix[row][col] == 0){
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }

        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0){
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0){
                matrix[i] = new int[matrix[0].length];
            }
        }

        if (firstRow)
            matrix[0] = new int[matrix[0].length];

        if (firstCol){
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {2,1,2,0,7},
                {0,4,0,2,1},
                {1,3,2,7,6},
                {2,4,1,3,5},
                {1,1,2,4,5},
                {1,1,4,2,2}
        };
        new Problem73().setZeroes(mat);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

}
