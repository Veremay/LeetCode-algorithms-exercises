public class rob {
    public static void main(String[] args) {

    }

    class Solution{
        public int rob(int[] nums) {
            if(nums.length == 1) return nums[0];

            // dp[i]表示到i这个房屋，能偷到最多的金额
            int[] dp = new int[nums.length];

            // 初始化
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);

            for (int i = 2; i < nums.length; i++) {
                // 偷/不偷
                dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
            }

            return dp[nums.length - 1];
        }
    }
}
