public class canPartition {
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int n = nums.length;
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }

        if(sum % 2 != 0) return false; //总和为奇数，不能平分

        int target = sum / 2;
        int[] dp = new int[target + 1]; //注意，j的含义是背包的容量，这里重量和价值是相等的

        // 这里省略了初始化，因为全部为0

        for (int i = 0; i < n; i++) {
            for (int j = target; j >= nums[i] ; j--) {
                //物品 i 的重量是 nums[i]，其价值也是 nums[i]
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }

            // 剪枝
            if(dp[target] == target)
                return true;
        }

        return dp[target] == target;
    }
}
