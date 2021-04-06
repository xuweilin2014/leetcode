package offer.question11_20.solutions;

public class QSolution15 {

    /*
     * 二进制中 1 的个数
     *
     * 统计一个十进制数 num 的二进制表示中 1 的个数，这里需要考虑到两点：
     * 1.这个数有可能是负数，比如 -3，在计算机中使用补码表示，这里统计的就是这个补码中 1 的个数。
     * 2.在进行条件判断时，不能使用 num & mask > 0，这是因为，num & mask 的结果有可能是小于 0 的，因为 num 是负数，所以其第一位符号位为 1，
     * 因此，应该改为 num & mask != 0
     */

}
