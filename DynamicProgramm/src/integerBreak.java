public class integerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1]; // 直接使用 dp[i] 表示正整数 i 的拆分结果，所以需要下标n

        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i/2;  j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i-j]));
            }
        }

        return dp[n];
    }
}
