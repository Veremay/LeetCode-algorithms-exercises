public class maxProfitFreeze {
    public int maxProfitFreeze(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][4];
        //[i][0]表示持有股票 ，[i][1]卖出股票状态，[i][2]今天卖出股票，[i][3]今天在冷冻期
        // 从递推公式可以看出，只需要初始化dp[0][j]
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        dp[0][3] = 0;

        for (int i = 1; i < n; i++) {
            // 状态一：持有股票状态（今天买入股票[两种情况：前一天不是/是冷冻期]，或者是之前就买入了股票然后没有操作，一直持有）
            dp[i][0] = Math.max(Math.max(dp[i - 1][1] - prices[i], dp[i - 1][3] - prices[i]), dp[i - 1][0]);
            // 状态二：保持卖出股票的状态（两天前就卖出了股票，度过一天冷冻期。或者是前一天就是卖出股票状态，一直没操作）
            dp[i][1] = Math.max(dp[i - 1][3], dp[i - 1][1]);
            // 状态三：今天卖出股票
            dp[i][2] = dp[i - 1][0] + prices[i];
            //状态四：今天在冷冻期
            dp[i][3] = dp[i - 1][2];
        }

        // 最后一定不是持有股票的状态
        return Math.max(Math.max(dp[n - 1][1], dp[n - 1][2]), dp[n - 1][3]);
    }
}
