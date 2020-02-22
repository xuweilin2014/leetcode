package xu.bfs;

import java.util.*;

public class Problem752 {
    public int openLock(String[] deadends, String target) {
        Set<String> deadnums = new HashSet<>(Arrays.asList(deadends));

        if (deadnums.contains(target) || deadnums.contains("0000"))
            return -1;

        Set<String> visited = new HashSet<>();
        int level = 0;
        Queue<String> queue = new ArrayDeque<>();
        queue.add(target);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                if (deadnums.contains(str))
                    continue;
                if (str.equals("0000")){
                    return level;
                }
                for (int j = 0; j < 4; j++) {
                    StringBuilder sb1 = new StringBuilder(str);
                    StringBuilder sb2 = new StringBuilder(str);
                    if (str.charAt(j) == '0'){
                        sb1.setCharAt(j, '1');
                        sb2.setCharAt(j, '9');
                    }else if (str.charAt(j) == '9'){
                        sb1.setCharAt(j, '8');
                        sb2.setCharAt(j, '0');
                    }else{
                        sb1.setCharAt(j, (char) (sb1.charAt(j) + 1));
                        sb2.setCharAt(j, (char) (sb2.charAt(j) - 1));
                    }
                    if (!visited.contains(sb1.toString()))
                        queue.add(sb1.toString());
                    if (!visited.contains(sb2.toString()))
                        queue.add(sb2.toString());
                    visited.add(sb1.toString());
                    visited.add(sb2.toString());
                }
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Problem752().openLock(new String[]{
                "1131","1303","3113","0132","1301","1303","2200","0232","0020","2223"
        }, "3312"));
    }

}
