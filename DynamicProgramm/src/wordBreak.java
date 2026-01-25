import java.util.ArrayList;
import java.util.List;

public class wordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;

        // 遍历所有可能的分割点
        for (int i = 1; i <= s.length(); i++) {
            // 检查所有可能的分割点j
            for (int j = 0; j < i; j++) {
                // 如果前j个字符可以被分割，且s[j:i]在字典中
                if (dp[j] == 1 && wordDict.contains(s.substring(j, i))) {
                    dp[i] = 1;
                    break; // 找到一个有效分割即可
                }
            }
        }


        return dp[s.length()] == 1;

        // 以下是错误版本
//        int[] dp = new int[s.length() + 1];
//        dp[0] = 1;
//
//        // 先遍历背包，再遍历物品
//        int start = 0;
//        for (int i = start; i <= s.length(); i++) {
//            for (int j = 0; j < wordDict.size(); j++) {
//                if(dp[start] == 1 && s.substring(start, i).equals(wordDict.get(j))){
//                    dp[i] = 1;
//                    start = i;
//                }
//            }
//        }
//
//        for(int i : dp){
//            System.out.println(i);
//        }

//        return dp[s.length()] == 1;
    }

    public static void main(String[] args) {
        String s = "aaaaaaa";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("aaaa");
        wordDict.add("aaa");

        boolean result = wordBreak(s, wordDict);
    }
}
