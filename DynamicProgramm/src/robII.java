public class robII {
    public int robII(int[] nums){
        if(nums.length == 1) return nums[0];
        int left = robRange(nums, 0, nums.length - 2);
        int right = robRange(nums, 1, nums.length - 1);
        return Math.max(left, right);
    }

    public int robRange(int[] nums, int start, int end) {
        if (end == start) return nums[start];

        int[] dp = new int[end - start + 1];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = 2; i < end - start + 1; i++) {
            dp[i] = Math.max(dp[i-2] + nums[start + i], dp[i-1]);
        }

        return dp[dp.length - 1];
    }
}
