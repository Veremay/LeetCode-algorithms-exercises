import java.util.*;

public class numIslands {
    static int result = 0;
    public static int[][] dir ={{0,1},{1,0},{-1,0},{0,-1}}; // 下右左上
    public static void dfs(int[][] grid, boolean[][] visited, int x, int y){
        for (int i = 0; i < dir.length; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            if (nextY < 0 || nextX < 0 || nextX >= grid.length || nextY >= grid[0].length)
                continue;
            if (grid[nextX][nextY] == 1 && !visited[nextX][nextY]){
                visited[nextX][nextY] = true;
                dfs(grid, visited, nextX, nextY);
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 行数
        int m = scanner.nextInt(); // 列数

        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        boolean[][] visited = new boolean[n][m];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 1 && !visited[i][j]){
                    result ++;
                    visited[i][j] = true;
                    dfs(grid, visited, i, j);
                }
            }
        }

        System.out.println(result);
    }
}
