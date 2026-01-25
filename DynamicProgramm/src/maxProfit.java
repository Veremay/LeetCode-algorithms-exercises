public class maxProfit {
    public int maxProfit(int[] prices) {
        // dp[i][0]表示第i天持有股票的话所得最多现金，dp[i][1]表示第i天不持有股票的话所得最多现金
        int[][] dp = new int[prices.length][2];

        dp[0][0] -= prices[0]; // 第0天持有股票，此时的持有股票就一定是买入股票了
        dp[0][1] = 0; // dp[0][1]表示第0天不持有股票，不持有股票那么现金就是0，所以dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]); // 要么i-1天就持有，要么刚刚买入
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]); // 要么i-1天就不持有，要么刚刚卖出
        }

        return  dp[prices.length - 1][1];
    }
}
