public class findMaxForm {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1]; // m个0，n个1

        dp[0][0] = 0;

        for(String str: strs){
            int zeroNum = 0;
            int oneNum = 0;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '0') {
                    zeroNum++;
                } else if (c == '1') {
                    oneNum++;
                }
            }

            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-zeroNum][j-oneNum]+1);
                }
            }
        }

        return dp[m][n];
    }
}
