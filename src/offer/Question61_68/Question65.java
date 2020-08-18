package offer.Question61_68;

public class Question65 {

    public int add(int a, int b) {
        int sumWithNoCarry = a ^ b;
        int carry = (a & b) << 1;

        while (carry != 0){
            a = sumWithNoCarry;
            b = carry;
            sumWithNoCarry = a ^ b;
            carry = (a & b) << 1;
        }

        return sumWithNoCarry;
    }

    public static void main(String[] args) {
        System.out.println(new Question65().add(29, 11));
    }

}
