package offer.question1_10.solutions;

public class QSolution4 {

    /*
     * 二维数组中的查找
     *
     * 利用二维数组 array 中的大小关系，可以从矩阵的右上角开始遍历去查找 target，也就是从 i = 0, j = cols - 1
     * 开始遍历：
     * 1.如果 array[i][j] = target，直接返回 true
     * 2.如果 array[i][j] > target，那么就从 array[i][j-1] 开始遍历，也就是 j--
     * 3.如果 array[i][j] < target，那么 i++
     */

}
