public class combinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i >= nums[j]){  // 当 i == nums[j] 时，应该加上 dp[0]，也就是1
                    dp[i] = dp[i] + dp[i-nums[j]];
                }
            }
        }

        return dp[target];
    }
}
