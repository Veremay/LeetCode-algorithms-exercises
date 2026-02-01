public class numDistinct {
    // 在 s 的 子序列 中 t 出现的个数
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        // 初始化，当t中还没有取出字符时，那无论无何也可以匹配一个
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                }else{
                    dp[i][i] = dp[i-1][j];
                }
            }
        }

        return dp[s.length()][t.length()];
    }
}
