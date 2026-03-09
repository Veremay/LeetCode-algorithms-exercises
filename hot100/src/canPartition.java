public class canPartition {
    public static void main(String[] args) {

    }

    class Solution{
        public boolean canPartition(int[] nums) {
            if(nums.length == 1) return false;
            int sum = 0;
            for(int num : nums){
                sum += num;
            }

            if(sum % 2 != 0) return false; // 和为奇数不可能被分成两半

            int target = sum / 2; // 要凑到的数字

            // dp[j] 表示是否存在子集的和为 j
            int[] dp = new int[target + 1];
            dp[0] = 1; // 空集和为0

            // 0-1背包问题，先遍历物品，再反向遍历背包

            for (int i = 0; i < nums.length; i++) {
                for (int j = target; j >= nums[i] ; j--) {
                    if (dp[j - nums[i]] == 1) {
                        dp[j] = 1;
                    }
                }
            }

            return dp[target] == 1;
        }
    }
}
