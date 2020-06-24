package offer.question1_10;

//从数组的右上角开始查找
public class Question4 {

    public static void main(String[] args) {
        System.out.println(new Question4().findNumberIn2DArray(new int[][]{
        }, 0));
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int rows = matrix.length;

        if (rows == 0)
            return false;

        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++){
            for (int j = cols - 1; j >= 0; j--){
                if (matrix[i][j] == target)
                    return true;
                else if (matrix[i][j] > target){
                    cols--;
                }else{
                    break;
                }
            }
        }

        return false;
    }

}
