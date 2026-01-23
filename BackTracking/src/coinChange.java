public class coinChange {
    public int coinChange(int[] coins, int amount) {
        // 创建 dp 数组
        int[] dp = new int[amount + 1];

        // 初始化
        for (int i = 0; i <= amount; i++) {
            dp[i] = amount + 1;  // 初始化为一个不可能的大值（这里用MAX_VALUE可能会溢出，所以最好用amount+1）
        }
        dp[0] = 0;  // 金额为0时不需要硬币

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j-coins[i]] + 1);
            }
        }

        // 判断是否有解
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
