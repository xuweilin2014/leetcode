package offer.Question61_68.problems;

/**
 * 无进位和 与 异或运算 规律相同
 * 进位 和 & 运算 规律相同（不过需要左移一位）
 * 无进位和 n = a ^ b
 * 进位 c = a & b << 1
 * 因此可以将 s = a + b 转换为 s = n ^ c，不断循环求 s，直到进位 c = 0
 */
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
