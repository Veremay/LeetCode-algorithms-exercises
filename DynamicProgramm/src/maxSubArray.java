public class maxSubArray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = dp[0];

        for (int i = 1; i < nums.length; i++) {
            if((dp[i-1] + nums[i]) < nums[i]){
                dp[i] = Math.max(nums[i], nums[i-1] + nums[i]);
            }else{
                dp[i] = dp[i-1] + nums[i];
            }

            result = Math.max(result, dp[i]);
        }

        return result;
    }
}
