package xu.tree;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class Problem1104 {

    public static List<Integer> pathInZigZagTree(int label) {
        int layer = 1;
        int val = 1;
        List<Integer> result = new ArrayList<>();
        while (true){
            int len = (int) Math.pow(2, layer - 1);
            if (label >= val && label <= val + len - 1){
                break;
            }
            val += (len);
            layer = layer + 1;
        }

        result.add(label);
        int pos = 0;
        if ((layer) % 2 == 0){
            pos = (int) (Math.pow(2, layer) - label);
        }else{
            pos = (int) (label - Math.pow(2, layer - 1) + 1);
        }
        for (int i = layer - 1; i >= 1; i--){
            if (pos % 2 != 0){
                pos = pos / 2 + 1;
            }else{
                pos = pos / 2;
            }
            if (i % 2 == 0){
                label = (int) Math.pow(2, i) - pos;
            }else{
                label = (int) Math.pow(2, i - 1) + pos - 1;
            }
            result.add(label);
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        Integer[] int1 = new Integer[]{1,3,2,4,5,6,7,15,14,13,12,11,10,9,8};

        TreeNode root1 = TreeUtil.buildTree(int1);
        List<Integer> list = Problem1104.pathInZigZagTree(14);
        System.out.println(list);
    }

}
