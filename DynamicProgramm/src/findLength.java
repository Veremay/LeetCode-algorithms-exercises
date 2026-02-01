import java.util.Arrays;

public class findLength {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        int result = 0; // 可能一个重复的也没有

        // 初始化第一列
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == nums2[0]) {
                dp[i][0] = 1;
                result = Math.max(dp[i][0], result);
            }
        }

        // 初始化第一行
        for (int j = 0; j < nums2.length; j++) {
            if (nums1[0] == nums2[j]) {
                dp[0][j] = 1;
                result = Math.max(dp[0][j], result);
            }
        }

        for (int i = 1; i < nums1.length; i++) {
            for (int j = 1; j < nums2.length; j++) {
                if(nums1[i] == nums2[j]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }

        return result;
    }
}
