package xu.array;

public class Problem59 {

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(8);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%2d ", matrix[i][j] );
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        doGenerateMatrix(n, 0, matrix, 1);
        return matrix;
    }

    public static void doGenerateMatrix(int n, int begin, int[][] matrix, int val){
        if (n <= 0)
            return;
        if (n == 1){
            matrix[begin][begin] = val;
            return;
        }

        int row = begin, col = begin;
        int counter = 1;
        while (counter++ <= n - 1){
            matrix[row][col++] = val++;
        }

        counter = 1;
        while (counter++ <= n - 1){
            matrix[row++][col] = val++;
        }

        counter = 1;
        while (counter++ <= n - 1){
            matrix[row][col--] = val++;
        }

        counter = 1;
        while (counter++ <= n - 1){
            matrix[row--][col] = val++;
        }

        doGenerateMatrix(n - 2, begin + 1, matrix, val);
    }

}
