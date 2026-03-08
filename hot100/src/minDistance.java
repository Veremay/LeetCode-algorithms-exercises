public class minDistance {
    public static void main(String[] args) {
        String word1 = "a";
        String word2 = "b";

    }

    static class Solution {
        public static int minDistance(String word1, String word2) {
            if(word1.length() == 0) return word2.length();
            if(word2.length() == 0) return word1.length();
            // dp[i][j]表示word1[i-1]、word2[j-1]结尾的字符串最少操作次数
            int[][] dp = new int[word1.length()+1][word2.length()+1];

            // 初始化
            for (int i = 0; i <= word1.length(); i++) {
                dp[i][0] = i;
            }
            for (int j = 0; j <= word2.length(); j++) {
                dp[0][j] = j;
            }

            for (int i = 1; i <= word1.length(); i++) {
                for (int j = 1; j <= word2.length(); j++) {
                    if(word1.charAt(i-1) == word2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1];  //不用进行任何操作
                    }else{
                        int a = dp[i-1][j] + 1; // 删除word1[i-1]
                        int b = dp[i][j-1] + 1; // 删除word2[j-1]
                        int c = dp[i-1][j-1] + 1; // 替换
                        dp[i][j] = Math.min(a, Math.min(b, c));
                    }
                }
            }

            return dp[word1.length()][word2.length()];

        }
    }
}
