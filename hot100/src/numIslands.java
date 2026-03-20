public class numIslands {
    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
        System.out.println(Solution.numIslands(grid));

    }

    static class Solution{
        private static int numIslands(char[][] grid) {
            int count = 0;
            int m = grid.length;
            int n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(grid[i][j] == '1'){
                        count ++;
                        dfs(i, j, m, n, grid);
                    }
                }
            }

            return count;
        }

        private static void dfs(int i, int j, int m, int n, char[][] grid){
            if(i < 0 || i >= m || j < 0 || j >= n){
                return;
            }
            if(grid[i][j] == '0'){
                return;
            }

            grid[i][j] = '0';

            dfs(i, j-1, m, n, grid);
            dfs(i - 1, j, m, n, grid);
            dfs(i, j+1, m, n, grid);
            dfs(i+1, j, m, n, grid);
        }
    }
}
