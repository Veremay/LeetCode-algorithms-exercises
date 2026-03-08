public class longestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(Solution.longestCommonSubsequence(text1, text2));
    }

    static class Solution {
        public static int longestCommonSubsequence(String text1, String text2) {
            // dp[i][j]表示text1[0,i-1]、text2[0,j-1]的最长公共子序列
            int[][] dp = new int[text1.length()+1][text2.length()+1];

            // 初始化
            // 当i=0或者j=0时，相当于是空字符串，所以公共子序列长度肯定为0

            // 从左上、上、左推导而来
            for (int i = 1; i <= text1.length(); i++) {
                for (int j = 1; j <= text2.length(); j++) {
                    if(text1.charAt(i-1) == text2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
//                    System.out.print(dp[i][j] + " ");
                }
//                System.out.println();
            }

            return dp[text1.length()][text2.length()];

        }
    }
}
