package xu.array;

public class Problem74 {

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 50));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0 || target < matrix[0][0])
            return false;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = rows - 1;
        for (int i = rows - 1; i >= 0; i--) {
            if (matrix[i][0] <= target) {
                row = i;
                break;
            }
        }

        int low = row * cols;
        int high = low + cols - 1;
        while (low <= high){
            int mid = (low + high) / 2;
            int val = matrix[mid / cols][mid % cols];
            if (target == val)
                return true;
            else if (target > val)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return false;
    }

}
