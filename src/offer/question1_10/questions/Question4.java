package offer.question1_10.questions;

//从数组的右上角开始查找
public class Question4 {

    public static void main(String[] args) {
        System.out.println(new Question4().Find(0, new int[][]{
        }));
        System.out.println(new Question4().Find(3, new int[][]{
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}
        }));
    }

    public boolean Find(int target, int [][] array) {
        if (array == null || array.length == 0)
            return false;

        int rows = array.length;
        int cols = array[0].length;
        int begin = 0;
        for (int j = cols - 1; j >= 0; j--) {
            for (int i = begin; i < rows; i++) {
                if (target == array[i][j])
                    return true;

                if (target < array[i][j]){
                    begin = i;
                    break;
                }
            }
        }

        return false;
    }

}
