package now_coder.sort;

public class SortTestHelper {

    // SortTestHelper不允许产生任何实例
    private SortTestHelper(){}

    // 生成有n个元素的随机数组,每个元素的随机范围为[rangeL, rangeR]
    public static int[] generateRandomArray(int n, int rangeL, int rangeR) {
        assert rangeL <= rangeR;

        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = (int) (Math.random() * (rangeR - rangeL + 1) + rangeL);

        return arr;
    }

    // 打印arr数组的所有内容
    public static void printArray(Object[] arr) {
        for (Object o : arr) {
            System.out.print(o);
            System.out.print(' ');
        }
        System.out.println();
    }

}
