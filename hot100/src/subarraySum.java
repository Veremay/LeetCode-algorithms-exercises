import java.util.*;

public class subarraySum {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1};
        int k = 2;
        System.out.println(Solution.subarraySum(nums,k));
    }

    static class Solution{
        public static int subarraySum(int[] nums, int k) {
            if(nums.length == 1 && nums[0] != k) return 0;

            int result = 0, sum = 0;

            Map<Integer, Integer> map = new HashMap<>();

            map.put(0, 1); // 前缀和为0出现一次，用于处理从0开始的子数组
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                // 查询和更新的顺序很重要，如果先更新，当遇到k=0的情况时，会把自己也算进去
                if(map.containsKey(sum - k)) result += map.get(sum - k);
                map.put(sum, map.getOrDefault(sum,0) + 1);
            }

            return result;

        }
    }


}
