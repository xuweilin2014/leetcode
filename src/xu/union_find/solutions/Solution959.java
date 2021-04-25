package xu.union_find.solutions;

public class Solution959 {

    /*
     * 由斜杠划分区域
     *
     * 这道题目其实是变相地求解连通区域的问题。将每一个 '/' 和 '\' 所占的方格划分成 4 个小块，按顺时针编号为:
     * base, base + 1, base + 2, base + 3。并且 base + 1 和 base + 7 是连通的，base + 2 和 base + cols * 4 也是连通的，
     * 并且如果是 '/' 这个符号的话，那么 base 和 base + 3 是连通的，同时 base + 1 和 base + 2 也是连通的，
     * 如果是 '\' 这个符号的话，那么 base 和 base + 1 是连通的，同时 base + 2 和 base + 3 也是连通的，
     * 据此，可以进行并查集中的 union 操作，最后判断 uf 中 -1 也就是根结点的个数，就是连通区域的个数
     */

}
