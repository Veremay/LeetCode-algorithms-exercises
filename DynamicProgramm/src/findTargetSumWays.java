public class findTargetSumWays {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i: nums){
            sum += i;
        }

        if(sum < target || sum < -target){
            return 0;
        }
        if((sum + target) % 2 != 0){
            return 0;
        }

        int positive = (sum + target) / 2;
        int[] dp = new int[positive + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = positive; j >= nums[i]; j--) {
                dp[j] = dp[j] + dp[j-nums[i]]; // 总方法数 = 不放 nums[i] 的方法数 + 放入 nums[i] 的方法数
            }
        }

        return dp[positive];
    }
}
