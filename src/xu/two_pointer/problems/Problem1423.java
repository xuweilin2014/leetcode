package xu.two_pointer.problems;

public class Problem1423 {

    public int maxScore(int[] cardPoints, int k) {
        if (cardPoints == null || cardPoints.length == 0)
            return 0;
        if (k >= cardPoints.length){
            int sum = 0;
            for (int point : cardPoints) {
                sum += point;
            }
            return sum;
        }

        int low = 0;
        int high = k - 1;
        int points = 0;
        int maxPoints = Integer.MIN_VALUE;
        for (int i = low; i <= high; i++) {
            points += cardPoints[i];
        }

        while (high != cardPoints.length - 1){
            maxPoints = Math.max(maxPoints, points);
            int copyHigh = high;
            low = (low - 1 + cardPoints.length) % cardPoints.length;
            high = (high - 1 + cardPoints.length) % cardPoints.length;
            points = points - cardPoints[copyHigh] + cardPoints[low];
        }

        return Math.max(maxPoints, points);
    }

    public static void main(String[] args) {
        System.out.println(new Problem1423().maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
        System.out.println(new Problem1423().maxScore(new int[]{1, 79, 80, 1, 1, 1, 200, 1}, 3));
        System.out.println(new Problem1423().maxScore(new int[]{2, 2, 2}, 2));
        System.out.println(new Problem1423().maxScore(new int[]{9 ,7, 7, 9, 7, 7, 9}, 7));
        System.out.println(new Problem1423().maxScore(new int[]{1, 1000, 1}, 1));
    }

}
