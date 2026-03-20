import java.util.*;
public class isolateAreaSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int result = Solution.isolateAreaSum(grid);
        System.out.println(result);
    }

    static class Solution{
        int result = 0, curResult = 0;
        private static int isolateAreaSum(int[][] grid){
            int m = grid.length;
            int n = grid[0].length;
            int count = 0;
            // 从四条边出发，把所有连通的都标为0
            // 最后再遍历一次计数
            for (int j = 0; j < n; j++) {
                if(grid[0][j] == 1){
                    dfs(0, j, m, n, grid);
                }
            }

            for (int j = 0; j < n; j++) {
                if(grid[m-1][j] == 1){
                    dfs(m-1, j, m, n, grid);
                }
            }

            for (int i = 0; i < m; i++) {
                if(grid[i][0] == 1){
                    dfs(i, 0, m, n, grid);
                }
            }

            for (int i = 0; i < m; i++) {
                if(grid[i][n-1] == 1){
                    dfs(i, n-1, m, n, grid);
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(grid[i][j] == 1) count ++;
                }
            }

            return count;
        }

        private static void dfs(int x, int y, int m, int n,int[][] grid){
            if( x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0){
                return;
            }
            grid[x][y] = 0;

            dfs(x, y-1, m, n, grid);
            dfs(x - 1, y, m, n, grid);
            dfs(x, y+1, m, n, grid);
            dfs(x+1, y, m, n, grid);

        }

    }
}
