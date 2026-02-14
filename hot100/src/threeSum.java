import java.util.*;

public class threeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(Solution.threeSum(nums));
    }

    static class Solution{
        // 当数组包含负数时，我们不再使用左右移动的窗口，而是改用 前缀和（Prefix Sum）。
        public static List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }  //去重第一个数
                int left = i + 1;
                int right = nums.length - 1;
                while(left < right){
                    if(nums[i] + nums[left] + nums[right] < 0){
                        left ++;
                    } else if (nums[i] + nums[left] + nums[right] > 0) {
                        right --;
                    }else{
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        // 找到了第一个三元组后，去重第二个数和第三个数
                        left ++;
                        right --;
                        while(left < right && nums[left] == nums[left-1]) left++;
                        while(left < right && nums[right] == nums[right+1]) right--;
                    }
                }
            }

            return result;
        }
    }
}
