import java.util.*;
public class findMaxLength {
    public static void main(String[] args) {
        int[] nums = {0,1,1,1,1,1,0,0,0};
        System.out.println(Solution.findMaxLength(nums));
    }
    static class Solution {
        // 将 0 视为 -1，将 1 视为 1，问题就转化为了“求和为 0 的最长子数组”。
        // 优化方案：前缀和 + 哈希表
        // 我们只需要在一次遍历中，记录每个前缀和第一次出现的下标。
        public static int findMaxLength(int[] nums) {
            Map<Integer,Integer> map = new HashMap<>();

            int sum = 0;
            // 初始化：前缀和为 0 的坐标设为 -1（处理从索引 0 开始就满足条件的情况）
            map.put(sum, -1);
            int maxLen = 0;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] == 0){
                    sum -= 1;
                }else{
                    sum += 1;
                }
                if(map.containsKey(sum)){
                    int len = i - map.get(sum);
                    maxLen = Math.max(len, maxLen);
                }else{
                    map.put(sum, i);
                }
            }

            return maxLen;

        }
        // 超时了
        /**
        public static int findMaxLength(int[] nums) {
            int[] preSum = new int[nums.length + 1];
            int sum = 0;
            for (int i = 1; i <= nums.length; i++) {
                sum += nums[i-1];
                preSum[i] = sum;
            }

            int max = 0;
            int right = preSum.length-1;
            while(right >= 0){
                for (int i = 0; i < right; i++) {
                    int minus = right - i;
                    if(minus == 2 * (preSum[right] - preSum[i]) ){
                        max = Math.max(minus, max);
                    }
                }
                right --;
            }
            return max;
        }
         **/
    }
}
