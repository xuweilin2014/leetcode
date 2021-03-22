package offer.Question61_68.problems;

public class Question64 {

    public int sumNums(int n) {
        int sum = n;
        boolean flag = n != 0 && ((sum += sumNums(n - 1)) != 0);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Question64().sumNums(9));
    }

}
