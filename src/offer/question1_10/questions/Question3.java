package offer.question1_10.questions;

public class Question3 {

    public static void main(String[] args) {
        System.out.println(findRepeatNumber(new int[]{2, 1, 3, 1, 4}));
        System.out.println(findRepeatNumber(new int[]{2, 4, 1, 0, 2, 5, 3}));
    }

    public static int findRepeatNumber(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int val = numbers[i];
            if (i != val){
                if (numbers[val] == val)
                    return val;
                else {
                    int tmp = numbers[i];
                    numbers[i] = numbers[val];
                    numbers[val] = tmp;
                    i--;
                }
            }
        }

        return -1;
    }

}
