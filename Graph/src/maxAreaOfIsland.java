import java.util.*;

public class maxAreaOfIsland {
    static int result = 0;
    static int curResult = 0;

    public static int[][] dir = {{0, -1}, {1, 0}, {-1, 0}, {0, 1}};

    public static void dfs(int[][] grid, int x, int y) {
        // 边界检查
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
            return;
        }

        // 访问当前节点
        grid[x][y] = 0;
        curResult++;

        // 更新最大面积
        if (curResult > result) {
            result = curResult;
        }

        // 向四个方向扩展
        for (int i = 0; i < dir.length; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            dfs(grid, nextX, nextY);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 行
        int m = scanner.nextInt(); // 列

        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    curResult = 0;  // 重置当前岛屿面积
                    dfs(grid, i, j);
                }
            }
        }
        System.out.println(result);
    }
}