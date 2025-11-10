import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourSum {
    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2};
        int target = 8;
        System.out.println(fourSum(nums, target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 剪枝
            if(nums[i] > target && target >= 0){
                break; // 这里使用break，通过最后的return返回
            }

            // 对nums[i]去重
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            for (int j = i+1; j < nums.length; j++) {
                // 剪枝
                if(nums[i] + nums[j] > target && target >= 0){
                    break;
                }

                // 对nums[j]去重
                if(j > i + 1 && nums[j] == nums[j - 1]){ // 注意，这里 j > i 永远为 true（因为 j 从 i+1 开始），应该为 j > i + 1。
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;
                while (left < right){
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum > target){
                        right--;
                    } else if (sum < target) {
                        left++;
                    }else{
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                        while(left < right && nums[left] == nums[left+1]){
                            left++;
                        }
                        while(left < right && nums[right] == nums[right-1]){
                            right--;
                        }

                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
