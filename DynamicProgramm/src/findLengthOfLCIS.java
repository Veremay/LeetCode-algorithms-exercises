import java.util.Arrays;

public class findLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int result = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]){
                dp[i] = dp[i - 1] + 1;
            }
            result = Math.max(result, dp[i]);
        }

        return result;
    }
}
