public class maxProfit {
    public static void main(String[] args) {

    }

    class Solution{
        public int maxProfit(int[] prices) {
            // dp[i][0]表示第i天持有股票的话所得最多现金，dp[i][1]表示第i天不持有股票的话所得最多现金
            int[][] dp = new int[prices.length][2];

            // 初始化
            dp[0][0] = -prices[0]; //第一天就持有的话，只能是刚买入
            dp[0][1] = 0;

            for (int i = 1; i < prices.length; i++) {
                dp[i][0] = Math.max(-prices[i], dp[i-1][0]); // 要么是刚买入，要么是i-1天就持有
                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]); // 要么是i-1天也不持有，要么是刚刚卖出
            }

            return dp[prices.length - 1][1];
        }
    }
}
