import java.util.*;

public class orangeRotting {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(Solution.orangesRotting(grid));
    }

    static class Solution {

        public static int orangesRotting(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int fresh = 0;

            Queue<Integer[]> queue = new LinkedList<>();

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(grid[i][j] == 2){
                        queue.add(new Integer[]{i,j});
                        grid[i][j] = 0; // 标记访问
                    }
                    if(grid[i][j] == 1){
                        fresh ++;
                    }
                }
            }

            if(fresh == 0) return 0;

            int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};//下右上左逆时针遍历
            int count = 0;

            while(!queue.isEmpty() && fresh > 0){ // 一定要加上fresh > 0，不然会把最后一步所有的腐烂橘子都取出来，多算一步
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    // 当前横纵坐标
                    int curX = queue.peek()[0];
                    int curY = queue.poll()[1];
                    for (int j = 0; j < 4; j++) {
                        int nextX = curX + dir[j][0];
                        int nextY = curY + dir[j][1];
                        if(nextX < 0 || nextX >= m || nextY < 0 || nextY >= n || grid[nextX][nextY] == 0){
                            continue;
                        }
                        if(grid[nextX][nextY] == 1){
                            queue.add(new Integer[]{nextX,nextY});
                            grid[nextX][nextY] = 0; // 标记访问
                            fresh --;
                        }
                    }
                }
                count ++;
            }

            if(fresh > 0) return -1;

            return count;
        }
    }
}
