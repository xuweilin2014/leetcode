package algorithm_analysis_and_design.divide_and_conquer;

public class RotateMatrix {

    private static int[][] data;

    public static void main(String[] args) {
        data = new int[6][6];
        full(data.length, 0, 1);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void full(int size, int begin, int end){
        if (size <= 0)
            return;

        int i = begin, j = begin;
        int val = end;
        int counter = 1;

        while (counter++ <= size - 1){
            data[i++][j] = val++;
        }

        counter = 1;
        while (counter++ <= size - 1){
            data[i][j++] = val++;
        }

        counter = 1;
        while (counter++ <= size - 1){
            data[i--][j] = val++;
        }

        counter = 1;
        while (counter++ <= size - 1){
            data[i][j--] = val++;
        }
        
        full(size - 2, begin + 1, val);
    }

}
