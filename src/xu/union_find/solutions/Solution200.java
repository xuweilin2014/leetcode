package xu.union_find.solutions;

public class Solution200 {

    /*
     * 岛屿数量
     *
     * 这道题目也可以通过并查集来实现，具体是对 grid 进行遍历，如果遍历到节点（i,j），并且 grid[i][j] = '1'，
     * 那么就判断节点（i,j）上下左右四个点是否也为 1，如果也为 1 的话，就调用 uf.union 将其加入到并查集中，依次类推。
     *
     * 上述过程执行完毕之后，如果 grid[i][j] == '1'，并且 uf.parents[i * cols + j] == -1，那么就说明这是单独一类
     * 等价类。
     */

}
