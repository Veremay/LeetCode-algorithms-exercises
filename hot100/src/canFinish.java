import java.util.*;

public class canFinish {
    public static void main(String[] args) {

    }

    static class Solution {
        public static boolean canFinish(int numCourses, int[][] prerequisites) {
            // 定义数据结构
            int[] inDegrees = new int[numCourses]; // 入度
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                adj.add(new ArrayList<>());
            }

            // 建图 prerequisites[i] = [a, b] 表示 b -> a (先修 b 才能上 a)
            for (int[] cp : prerequisites) {
                int pre = cp[1];
                int next = cp[0];
                adj.get(pre).add(next);
                inDegrees[next] ++; // 增加入度
            }

            // 将入度为 0 的节点入队
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (inDegrees[i] == 0) {
                    queue.offer(i);
                }
            }

            // 开始剥洋葱
            int count = 0; // 记录修完了多少课
            while(!queue.isEmpty()){
                int cur = queue.poll();
                count ++;
                for(int nb: adj.get(cur)){ // 遍历指向的所有邻居
                    inDegrees[nb] --;
                    if(inDegrees[nb] == 0){
                        queue.offer(nb);
                    }
                }
            }

            // 比较 count 和 numCourses
            return count == numCourses;
        }
    }
}
