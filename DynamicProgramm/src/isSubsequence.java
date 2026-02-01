public class isSubsequence {
    // 判断 s 是否为 t 的子序列
    public boolean isSubsequence_pointer(String s, String t) {
        // 先用双指针实现一下吧
        if(s.length() == 0 && s.length() == 0) return true;
        int sIndex = 0, tIndex = 0;

        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
            tIndex++;
        }

        return sIndex == s.length();

    }

    public boolean isSubsequence_dp(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return dp[s.length()][t.length()] == s.length();

    }
}
