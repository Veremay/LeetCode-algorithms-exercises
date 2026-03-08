public class longestPalindrome {
    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(Solution.longestPalindrome(s));
    }

    static class Solution{
        public static String longestPalindrome(String s) {
            // 定义dp数组 dp[i][j]表示s[i, j]是否为回文
            int[][] dp = new int[s.length()][s.length()];

            int start = 0;
            int maxLen = 1;

            // 初始化：每一个下标本身就是回文子串
            for (int i = 0; i < s.length(); i++) {
                dp[i][i] = 1;
            }

            // 从左下推理而来
            for (int i = s.length() - 1; i >= 0 ; i--) {
                for (int j = i; j < s.length(); j++) {
                    if(s.charAt(i) == s.charAt(j)){
                        if(i == j) dp[i][j] = 1;
                        else if(j - i == 1) dp[i][j] = 1;
                        else{
                            dp[i][j] = dp[i+1][j-1];
                        }

                        // 如果当前子串是回文，检查是否需要更新最长记录
                        if (dp[i][j] == 1 && (j - i + 1) > maxLen) {
                            maxLen = j - i + 1;
                            start = i;
                        }

                    }

                }
            }

            return s.substring(start, start + maxLen);
        }
    }
}
