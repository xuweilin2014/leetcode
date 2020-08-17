package offer.question41_50;

import offer.question1_10.Question4;

import java.util.ArrayList;
import java.util.List;

// 堆排序
public class Question41 {

    public static void main(String[] args) {
        Question41 q = new Question41();
        Question41.Insert(4);
        System.out.println(Question41.GetMedian());
        Question41.Insert(5);
        System.out.println(Question41.GetMedian());
        Question41.Insert(1);
        System.out.println(Question41.GetMedian());
        Question41.Insert(6);
        System.out.println(Question41.GetMedian());
        Question41.Insert(2);
        System.out.println(Question41.GetMedian());
        Question41.Insert(7);
        System.out.println(Question41.GetMedian());
        Question41.Insert(3);
        System.out.println(Question41.GetMedian());
        Question41.Insert(8);
        System.out.println(Question41.GetMedian());
        Question41.Insert(9);
        System.out.println(Question41.GetMedian());
        Question41.Insert(11);
        System.out.println(Question41.GetMedian());
        Question41.Insert(8);
        System.out.println(Question41.GetMedian());
    }

    private static final List<Integer> heap = new ArrayList<>();

    public static void Insert(Integer num) {
        heap.add(num);
        if (heap.size() < 3)
            return;
        else{
            for (int i = heap.size() / 2; i >= 0; i--) {
                adjust(heap, i, heap.size() - 1);
            }
            for (int i = heap.size() - 1; i >= 0; i--) {
                int tmp = heap.get(0);
                heap.set(0, heap.get(i));
                heap.set(i, tmp);
                adjust(heap, 0, i - 1);
            }
        }
    }

    public static Double GetMedian() {
        int len = heap.size();
        if (heap.size() % 2 == 0)
            return (heap.get(len / 2) + heap.get(len / 2 - 1)) / (double) 2;
        else
            return (double) heap.get(len / 2);
    }

    public static void adjust(List<Integer> heap, int s, int end){
        int val = heap.get(s);
        for (int j = s * 2; j <= end; j *= 2) {
            if (j < end && heap.get(j) < heap.get(j + 1))
                j++;
            if (val >= heap.get(j))
                break;
            heap.set(s, heap.get(j));
            heap.set(j, val);
            s = j;
        }
    }

}
