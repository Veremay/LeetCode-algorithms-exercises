import java.util.*;

public class wordBreak {
    public static void main(String[] args) {

    }

    class Solution{
        public boolean wordBreak(String s, List<String> wordDict) {
            int[] dp = new int[s.length() + 1];

            // 初始化
            dp[0] = 1; // 如果不为true的话，后面的全是false了

            // 排列问题，先遍历背包，再遍历物品
            // 验证s[j:i]区间
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j <= i; j++) {
                    // // 如果前j个字符可以被分割，且s[j:i]在字典中。注意这里i-1才是s的下标
                    if(dp[j] == 1 && wordDict.contains(s.substring(j, i))){
                        dp[i] = 1;
                        break; // 找到一个有效分割即可
                    }
                }
            }

            return dp[s.length()] == 1;
        }
    }
}
