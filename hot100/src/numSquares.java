public class numSquares {
    public static void main(String[] args) {

    }

    class Solution{
        public int numSquares(int n) {
            // dp[j] 表示 凑成和为j需要最少多少个完全平方数
            int[] dp = new int[n + 1];

            for (int i = 0; i < dp.length; i++) {
                dp[i] = Integer.MAX_VALUE;
            }
            dp[0] = 0;

            for (int i = 1; i * i <= n; i++) {
                for (int j = i * i; j <= n; j++) {
                    // 加上/不加上现在这个数的平方
                    dp[j] = Math.min(dp[j - i * i] + 1, dp[j]);
                }
            }

            return dp[n];
        }
    }
}
