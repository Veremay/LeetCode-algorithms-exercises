public class minDistanceII {
    public int minDistanceII(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];

        // 初始化
        for (int i = 1; i <= word1.length(); i++) {
            // 全部做删除操作
            dp[i][0] =  i;
        }
        for (int j = 1; j <= word2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    // 增和删其实是一个意思
                    // 要么对word1做出增/删，要么对word2做出增/删。dp[i-1][j] + 1, dp[i][j-1] + 1
                    // 替换的状态来源是左上角（保证顺序性）
                    dp[i][j] = Math.min(Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1), dp[i-1][j-1] + 1);
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
