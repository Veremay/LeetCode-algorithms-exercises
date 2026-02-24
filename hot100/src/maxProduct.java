public class maxProduct {
    public static void main(String[] args) {

    }

    class Solution{
        public int maxProduct(int[] nums){
            if(nums.length == 1) return nums[0];

            int[] dpMax = new int[nums.length];
            int[] dpMin = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {
                dpMax[i] = Integer.MIN_VALUE;
                dpMin[i] = Integer.MAX_VALUE;
            }
            dpMax[0] = nums[0];
            dpMin[0] = nums[0];

            int result = dpMax[0];

            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j <= i; j++) {
                    dpMax[i] = Math.max(nums[i], Math.max(dpMax[i-1] * nums[i], dpMin[i-1] * nums[i]));
                    dpMin[i] = Math.min(nums[i], Math.min(dpMax[i-1] * nums[i], dpMin[i-1] * nums[i]));
                }
                result = Math.max(result, dpMax[i]);
            }

            return result;
        }


        // 错误代码
        // 因为负负相乘可能更大，所以要维护两个dp数组
        public int maxProduct_error(int[] nums) {
            if(nums.length == 1) return nums[0];

            int[] dp = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {
                dp[i] = Integer.MIN_VALUE;
            }
            dp[0] = nums[0];

            int result = Integer.MIN_VALUE;

            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j <= i; j++) {
                    dp[i] = Math.max(nums[i], dp[i-1] * nums[i]);
                }
                result = Math.max(result, dp[i]);
            }

            return result;
        }
    }
}
