package offer.question31_40.solutions;

public class QSolution39 {

    /*
     * 数组中出现次数超过一半的数字
     *
     * 思考一下，假如数组是一个投票箱，其中每一张票上写着大家要选举的人的编号。那么，我们要做的事情，就是找到票数最多的那个人的编号。
     * 是不是感觉像这么回事儿？很好，我们再细化一下，分析如下：
     *
     * 假如我们有个职位，需要从 A，B 两位候选人中选出
     * 先抽出一张票，投的是 A，我们在黑板上写着当前胜利者：A，票数：1
     * 再抽出一张票，投的是 A，我们在黑板上写着当前胜利者：A，票数：2
     * 再抽出一张票，投的是 B，用一张 B 抵消一张 A 的选票，我们在黑板上写着当前胜利者：A，票数：1
     * 再抽出一张票，投的是 B，用一张 B 抵消一张 A 的选票，我们在黑板上写着当前胜利者：无，票数：0
     * 再抽出一张票，投的是 A，我们在黑板上写着当前胜利者：A，票数：1
     * 抽取完毕，恭喜 A 获胜，赢得该职位。
     *
     * 经过以上实例分析，我们可以得出 33 个要点：
     *
     * 不同候选人的选票之间，可以一一抵消。
     * 若当前胜利者存在多张选票时，不同的候选人的票，只能抵消一张当前胜利者的票。
     * 若当前双方的选票被抵消为零，下一次抽出的候选人，将作为暂时的胜利者领先。
     */

    // 摩尔投票法
    public int majorityElement(int[] array) {
        if (array.length == 1)
            return array[0];

        int counter = 1;
        int val = array[0];

        for (int i = 1; i < array.length; i++) {
            if (counter == 0){
                counter++;
                val = array[i];
                continue;
            }

            if (array[i] == val){
                counter++;
            }else{
                counter--;
            }
        }

        return val;
    }

}
