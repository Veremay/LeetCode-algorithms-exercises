public class countSubstrings {
    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        boolean[][] dp = new boolean[len][len];
        int result = 0;

        // 因为递推公式dp[i][j]依赖于左下角的值，所以遍历顺序应该是倒序的
        for (int i = len-1; i >= 0 ; i--) {
            for (int j = i; j < len ; j++) {
                if(chars[i] == chars[j]){
                    // 'a' 'aa'的情况
                    if(j - i <= 1){
                        dp[i][j] = true;
                        result ++;
                    }else{
                        if(dp[i+1][j-1] == true){
                            dp[i][j] = true;
                            result ++;
                        }
                    }
                }
            }
        }

        return result;

    }
}
