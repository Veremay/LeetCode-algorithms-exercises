public class coinChange {
    public static void main(String[] args) {

    }

    class Solution{
        public int coinChange(int[] coins, int amount) {
            // dp[i][j]表示用前i种硬币，凑成金额为j的最小硬币数
            int[][] dp = new int[coins.length + 1][amount + 1];
            // 初始化
            for (int j = 1; j <= amount; j++) {
                dp[0][j] = amount + 1;
            }
            dp[0][0] = 0;

            for (int i = 1; i <= coins.length; i++) {
                for (int j = 0; j <= amount; j++) {
                    // 用/不用第i种
                    // 用的话，因为是无限取用，所以当前硬币可能被取用过了，所以是dp[i]而不是dp[i-1]
                    if(j >= coins[i-1]){
                        dp[i][j] = Math.min(dp[i][j - coins[i-1]] + 1, dp[i-1][j]);
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }

            return dp[coins.length][amount] > amount ? -1 : dp[coins.length][amount];
        }

        // 试试一维dp数组
        public int coinChange_(int[] coins, int amount){
            // dp[j]表示凑成金额为j的最小硬币数
            int[] dp = new int[amount + 1];

            // 初始化
            for (int i = 0; i <= amount; i++) {
                dp[i] = amount + 1;  // 初始化为一个不可能的大值（这里用MAX_VALUE可能会溢出，所以最好用amount+1）
            }
            dp[0] = 0;  // 金额为0时不需要硬币

            for (int i = 0; i < coins.length; i++) {
                for (int j = coins[i]; j <= amount; j++) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }

            return dp[amount] > amount ? -1 : dp[amount];
        }
    }
}
