package xu.array;

/**
 * 二维矩阵顺时针旋转90度：先镜像翻转，再沿斜对称轴翻转
 */
public class Problem48 {

    public static void main(String[] args) {
        int[][] m = new int[][]{
                { 5, 1, 9,11},
                 {2, 4, 8,10},
                {13, 3, 6, 7},
                {15,14,12,16}
        };
        rotate(m);
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) {
        mirror(matrix);
        symmetry(matrix);
    }

    public static void mirror(int[][] matrix){
        int mid = matrix.length / 2;
        int len = matrix.length;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix[i].length - 1; j >= mid; j--) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][len - j - 1];
                matrix[i][len - j - 1] = tmp;
            }
        }
    }

    public static void symmetry(int[][] matrix){
        int thresh = matrix.length - 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i + j < thresh){
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[thresh - j][thresh - i];
                    matrix[thresh - j][thresh - i] = tmp;
                }
            }
        }
    }
}
