public class uniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // 起点或终点是障碍物
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) {
            return 0;
        }

        int[][] dp = new int[m][n];

        // 初始化起点
        dp[0][0] = 1;

        // 初始化第一列：只能从上往下走
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;  // 遇到障碍物，后面都为0
                // 可以加break，但为了代码简洁，继续循环也没问题
            } else {
                dp[i][0] = dp[i-1][0];  // 继续第一列的路径
            }
        }

        // 初始化第一行：只能从左往右走
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                dp[0][j] = 0;  // 遇到障碍物，后面都为0
                // 可以加break，但为了代码简洁，继续循环也没问题
            } else {
                dp[0][j] = dp[0][j-1];  // 继续第一行的路径
            }
        }

        // 填充剩余格子
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;  // 障碍物，不能到达
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[m-1][n-1];
    }
}
