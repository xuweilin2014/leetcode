package offer.question31_40.questions;

public class Question39 {

    public static void main(String[] args) {
        System.out.println(new Question39().MoreThanHalfNum_Solution(new int[]{1,2,3}));
        System.out.println(new Question39().MoreThanHalfNum_Solution(new int[]{3,2,3,2,3,3,3,3,3,2,2,3,3,5,4,2}));
        System.out.println(new Question39().MoreThanHalfNum_Solution(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
        System.out.println(new Question39().MoreThanHalfNum_Solution(new int[]{1,1,3}));
        System.out.println(new Question39().MoreThanHalfNum_Solution(new int[]{1,2,3,2,2,2,5,4,2}));
    }

    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0)
            return 0;

        int counter = 1;
        int val = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]){
                counter++;
            }else {
                counter--;
                if (counter == 0) {
                    counter = 1;
                    val = array[i];
                }
            }
        }

        int times = 0;
        for (int value : array) {
            if (value == val)
                times++;
        }

        if (times > array.length / 2)
            return val;
        else
            return 0;
    }

}
