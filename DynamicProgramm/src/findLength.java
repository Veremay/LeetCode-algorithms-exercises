import java.util.Arrays;

public class findLength {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 1);
        }

        int result = dp[0][0];
        for (int i = 1; i < nums1.length; i++) {
            for (int j = 1; j < nums2.length; j++) {
                if(nums1[i] == nums2[j]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
            }
        }
    }
}
