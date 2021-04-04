package offer.question1_10.solutions;

public class QSolution3 {

    /*
     * 数组中重复的数字
     *
     * 在这一道题目里面，一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内，但是有数字是重复的，并且不知道有
     * 多少个数字重复，也不知道重复了多少遍。然后需要找出重复的数字。
     *
     * 我们需要利用数组中的数字都在 0~n-1 之间这个性质，即遍历 nums 数组，假设遍历到下标为 i 的数字的话（假设 val = nums[i]），
     * 如果 val == i，那么就继续遍历下一个数字
     * 如果 val != i，那么就判断 nums[val] 的值是否等于 val
     *      如果等于的话，就说明 val 是重复的（nums[i] 和 nums[val] 都等于 val）
     *      如果不等于的话，就直接将 nums[val] 和 nums[i] 之间的数字对换
     */

}
