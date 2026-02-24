import java.util.Arrays;

public class lengthOfLIS {
    public static void main(String[] args) {

    }

    class Solution{
        public int lengthOfLIS(int[] nums){
            int[] dp = new int[nums.length];

            // 初始化：每个元素本身就是一个长度为1的递增子序列
            Arrays.fill(dp, 1);

            int result = dp[0];
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if(nums[i] > nums[j]){ // nums[i]可以放在nums[j]后面
                        dp[i] = Math.max(dp[i], dp[j] + 1); // 在所有候选值中取最大值，同时也要考虑 dp[i] 的初始值 1
                    }
                }
                result = Math.max(result, dp[i]);
            }

            return result;
        }
    }
}
